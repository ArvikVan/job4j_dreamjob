package dream.store;

import dream.models.Candidate;
import dream.models.Post;
import dream.models.User;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

/**
 * @author ArvikV
 * @version 1.0
 * @since 12.12.2021
 */
public class DbStoreTest {
    @Test
    public void whenCreatePost() {
        Store store = DbStore.instOf();
        Post post = new Post(0, "Java Job");
        store.savePost(post);
        Post postInDb = store.findByIdPost(post.getID());
        assertThat(postInDb.getName(), is(post.getName()));
    }
    @Test
    public void whenCreateCandidate() {
        Store store = DbStore.instOf();
        Candidate candidate = new Candidate(0, "Vasiliy Terkin");
        store.saveCandidate(candidate);
        Candidate candidateInDb = store.findByIdCandidate(candidate.getId());
        assertThat(candidateInDb.getName(), is(candidate.getName()));
    }
    @Test
    public void whenUpdatePost() {
        Store store = DbStore.instOf();
        Post post = new Post(0, "Java Job");
        store.savePost(post);
        post.setName("Updated Java Job");
        store.savePost(post);
        Post postInDb = store.findByIdPost(post.getID());
        assertThat(postInDb.getName(), is("Updated Java Job"));
    }
    @Test
    public void whenUpdateCandidate() {
        Store store = DbStore.instOf();
        Candidate candidate = new Candidate(0, "Vasiliy Terkin");
        store.saveCandidate(candidate);
        candidate.setName("Updated Vasiliy Terkin");
        store.saveCandidate(candidate);
        Candidate candidateInDb = store.findByIdCandidate(candidate.getId());
        assertThat(candidateInDb.getName(), is("Updated Vasiliy Terkin"));
    }
    @Test
    public void whenDeleteCandidate() {
        Store store = DbStore.instOf();
        Candidate candidate = new Candidate(0, "Vasiliy Terkin");
        store.saveCandidate(candidate);
        Candidate candidateInDb = store.findByIdCandidate(candidate.getId());
        store.deleteCandidate(candidateInDb.getId());
        assertThat(store.findByIdCandidate(candidateInDb.getId()), is(nullValue()));
    }

    @Test
    public void whenCreateUser() {
        Store store = DbStore.instOf();
        User user = new User(0, "Java Job");
        store.saveUser(user);
        User postInDb = store.findByIdUser(user.getId());
        assertThat(postInDb.getId(), is(user.getId()));
    }

}