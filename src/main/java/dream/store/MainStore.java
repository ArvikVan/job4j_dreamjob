package dream.store;

import dream.models.Candidate;
import dream.models.Post;

/**
 * @author ArvikV
 * @version 1.0
 * @since 10.12.2021
 */
public class MainStore {
    public static void main(String[] args) {
        Store store = DbStore.instOf();
        store.savePost(new Post(0, "Java Job"));
        store.savePost(new Post(1, "Maintery Job"));
        store.savePost(new Post(2, "Garden Job"));
        store.saveCandidate(new Candidate(0, "Ivan"));
        store.saveCandidate(new Candidate(1, "Semen"));
        store.saveCandidate(new Candidate(2, "Petr"));
        System.out.println(store.findByIdCandidate(1).getName());
        System.out.println(store.findByIdPost(1).getName());
        System.out.println(store.findByIdPost(3).getName());
        for (Post post : store.findAllPosts()) {
            System.out.println(post.getID() + " " + post.getName());
        }
        for (Candidate candidate : store.findAllCandidates()) {
            System.out.println(candidate.getId() + " " + candidate.getName());
        }

    }
}
