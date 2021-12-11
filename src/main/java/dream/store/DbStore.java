package dream.store;

import dream.models.Candidate;
import dream.models.Post;
import dream.servlet.UploadServlet;
import org.apache.commons.dbcp2.BasicDataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import dream.models.Candidate;
import dream.models.Post;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ArvikV
 * @version 1.0
 * @since 10.12.2021
 */
public class DbStore implements Store {
    private static final Logger LOGGER = LoggerFactory.getLogger(DbStore.class);
    private static final DbStore INSTANCE = new DbStore();
    private final BasicDataSource pool = new BasicDataSource();

    private DbStore() {
        Properties cfg = new Properties();
        try (BufferedReader io = new BufferedReader(
                new InputStreamReader(
                        DbStore.class.getClassLoader()
                                .getResourceAsStream("db.properties")
                )
        )) {
            cfg.load(io);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        try {
            Class.forName(cfg.getProperty("jdbc.driver"));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        pool.setDriverClassName(cfg.getProperty("jdbc.driver"));
        pool.setUrl(cfg.getProperty("jdbc.url"));
        pool.setUsername(cfg.getProperty("jdbc.username"));
        pool.setPassword(cfg.getProperty("jdbc.password"));
        pool.setMinIdle(5);
        pool.setMaxIdle(10);
        pool.setMaxOpenPreparedStatements(100);
    }

    private static final class Lazy {
        private static final Store INST = new DbStore();
    }

    public static Store instOf() {
        return Lazy.INST;
    }

    @Override
    public Collection<Post> findAllPosts() {
        List<Post> posts = new ArrayList<>();
        try (Connection cn = pool.getConnection();
             PreparedStatement ps =  cn.prepareStatement("SELECT * FROM post")
        ) {
            try (ResultSet it = ps.executeQuery()) {
                while (it.next()) {
                    posts.add(new Post(it.getInt("id"), it.getString("name")));
                }
            }
        } catch (Exception e) {
            LOGGER.error("public Collection<Post> findAllPosts()", e);
        }
        return posts;
    }

    @Override
    public Collection<Candidate> findAllCandidates() {
        List<Candidate> candidates = new ArrayList<>();
        try (Connection connection = pool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from candidate")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    candidates.add(new Candidate(resultSet.getInt("id"),
                            resultSet.getString("name")));
                }
            }
        } catch (Exception e) {
            LOGGER.error("public Collection<Candidate> findAllCandidates()", e);
        }
        return candidates;
    }

    @Override
    public void savePost(Post post) {
        if (post.getID() == 0) {
            createPost(post);
        } else {
            updatePost(post);
        }
    }

    @Override
    public void saveCandidate(Candidate candidate) {
        if (candidate.getId() == 0) {
            createCandidate(candidate);
        } else {
            updateCandidate(candidate);
        }
    }

    private void updatePost(Post post) {
        try (Connection cn = pool.getConnection();
             PreparedStatement ps = cn.prepareStatement("UPDATE post SET name = ? where id = ?")) {
            ps.setString(1, post.getName());
            ps.setInt(2, post.getID());
            ps.executeUpdate();
        } catch (Exception e) {
            LOGGER.error("private void updatePost(Post post)", e);
        }
    }

    private void updateCandidate(Candidate candidate) {
        try (Connection cn = pool.getConnection();
             PreparedStatement ps = cn.prepareStatement("UPDATE candidate SET name = ? where id = ?")) {
            ps.setString(1, candidate.getName());
            ps.setInt(2, candidate.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            LOGGER.error("private void updatePost(Post post)", e);
        }
    }

    @Override
    public Post findByIdPost(int id) {
        try (Connection cn = pool.getConnection();
             PreparedStatement ps =  cn.prepareStatement("SELECT * FROM post WHERE id = ?")
        ) {
            ps.setInt(1, id);
            try (ResultSet it = ps.executeQuery()) {
                if (it.next()) {
                    return new Post(it.getInt("id"), it.getString("name"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Candidate findByIdCandidate(int id) {
        try (Connection cn = pool.getConnection();
             PreparedStatement ps =  cn.prepareStatement("SELECT * FROM candidate WHERE id = ?")
        ) {
            ps.setInt(1, id);
            try (ResultSet it = ps.executeQuery()) {
                if (it.next()) {
                    return new Candidate(it.getInt("id"), it.getString("name"));
                }
            }
        } catch (Exception e) {
            LOGGER.error("public Candidate findByIdCandidate(int id)", e);
        }
        return null;
    }

    private Post createPost(Post post) {
        try (Connection cn = pool.getConnection();
             PreparedStatement ps =  cn.prepareStatement("INSERT INTO post(name) VALUES (?)",
                     PreparedStatement.RETURN_GENERATED_KEYS)
        ) {
            ps.setString(1, post.getName());
            ps.execute();
            try (ResultSet id = ps.getGeneratedKeys()) {
                if (id.next()) {
                    post.setID(id.getInt(1));
                }
            }
        } catch (Exception e) {
            LOGGER.error("private Post create(Post post)", e);
        }
        return post;
    }

    private Candidate createCandidate(Candidate candidate) {
        try (Connection cn = pool.getConnection();
             PreparedStatement ps =  cn.prepareStatement("INSERT INTO candidate(name) VALUES (?)",
                     PreparedStatement.RETURN_GENERATED_KEYS)
        ) {
            ps.setString(1, candidate.getName());
            ps.execute();
            try (ResultSet id = ps.getGeneratedKeys()) {
                if (id.next()) {
                    candidate.setId(id.getInt(1));
                }
            }
        } catch (Exception e) {
            LOGGER.error("private Candidate createCandidate(Candidate candidate)", e);
        }
        return candidate;
    }


}
