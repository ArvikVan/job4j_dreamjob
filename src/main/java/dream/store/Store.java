package dream.store;

import dream.models.Candidate;
import dream.models.City;
import dream.models.Post;
import dream.models.User;

import java.io.PipedOutputStream;
import java.util.Collection;

/**
 * @author ArvikV
 * @version 1.1
 * @since 10.12.2021
 *  Расширьте интерфейс Store. Добавьте методы для работы с классом User.
 */
public interface Store {
    Collection<Post> findAllPosts();

    Collection<Candidate> findAllCandidates();

    Collection<User> findAllUsers();

    Collection<City> findAllCities();

    Collection<Post> findLastDayPosts();

    Collection<Candidate> findLastDayCandidates();

    void savePost(Post post);

    void saveCandidate(Candidate candidate);

    void deletePost(int id);

    void deleteCandidate(int id);

    Post findByIdPost(int id);

    Candidate findByIdCandidate(int id);

    void saveUser(User user);

    void deleteUser(int id);

    User findByIdUser(int id);

    User findByEmailUser(String email);
}
