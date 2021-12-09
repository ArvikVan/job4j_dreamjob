package dream.store;

import dream.models.Post;

/**
 * @author ArvikV
 * @version 1.0
 * @since 10.12.2021
 */
public class MainStore {
    public static void main(String[] args) {
        Store store = DbStore.instOf();
        store.save(new Post(0, "Java Job"));
        store.save(new Post(1, "Maintery Job"));
        store.save(new Post(2, "Garden Job"));
        System.out.println(store.findById(1).getName());
        System.out.println(store.findById(3).getName());
        for (Post post : store.findAllPosts()) {
            System.out.println(post.getID() + " " + post.getName());
        }

    }
}
