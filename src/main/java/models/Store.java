package models;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ArvikV
 * @version 1.1
 * @since 05.12.2021
 * добавлены мапа для хранения кандидатов и метод для их возврата
 */
public class Store {
    private static final Store INST = new Store();

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();


    private Store() {
        posts.put(1, new Post(1, "Junior Java Developer"));
        posts.put(2, new Post(2, "Middle Java Developer"));
        posts.put(3, new Post(3, "Senior Java Developer"));
        candidates.put(1, new Candidate(1, "Junior Java(Candidate)"));
        candidates.put(2, new Candidate(2, "Middle Java(Candidate)"));
        candidates.put(3, new Candidate(3, "Senior Java(Candidate)"));
    }

    public static Store instOf() {
        return INST;
    }

    public Collection<Post> findAll() {
        return posts.values();
    }

    public Collection<Candidate> findAllCandidates() {
        return candidates.values();
    }

}
