package dream.store;

import dream.models.Candidate;
import dream.models.Post;

import java.io.PipedOutputStream;
import java.util.Collection;

/**
 * @author ArvikV
 * @version 1.0
 * @since 10.12.2021
 */
public interface Store {
    Collection<Post> findAllPosts();

    Collection<Candidate> findAllCandidates();

    void savePost(Post post);

    void saveCandidate(Candidate candidate);

    void deletePost(int id);

    void deleteCandidate(int id);

    Post findByIdPost(int id);

    Candidate findByIdCandidate(int id);
}
