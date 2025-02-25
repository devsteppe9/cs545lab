package miu.edu.cs545assignment.repository.impl;

import miu.edu.cs545assignment.domain.Post;
import miu.edu.cs545assignment.repository.PostRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepositoryJsonImpl implements PostRepository {
    private List<Post> posts;
    public PostRepositoryJsonImpl() {
        posts = loadPosts();
        posts.forEach(System.out::println);
    }

    @Override
    public List<Post> findAll() {
        return this.posts;
    }

    @Override
    public List<Post> filterByAuthor(String author) {
        return this.posts.stream()
                .filter(post -> post.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Post getById(long id) {
        return this.posts.stream()
                .filter(post -> post.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public void save(Post post) {
        this.posts.add(post);
    }

    @Override
    public void delete(long id) {
        this.posts.removeIf(post -> post.getId() == id);
    }

    @Override
    public void update(long id, Post updatedPost) {
        posts.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .ifPresent(existingPost -> {
                    existingPost.setTitle(updatedPost.getTitle());
                    existingPost.setContent(updatedPost.getContent());
                    existingPost.setAuthor(updatedPost.getAuthor());
                });
    }

    private List<Post> loadPosts() {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post(1, "Bobo, The", "Erythema [first degree] of multiple sites of lower limb(s)", "Marcy Willowby"));
        posts.add(new Post(2, "Waiting for Forever", "Excessive keratinized residual ridge mucosa", "Doria Griswaite"));
        posts.add(new Post(3, "Monsters vs. Aliens", "Toxic effect of venom", "Zacharie Cossons"));
        posts.add(new Post(4, "Monster in Paris, A (Un monstre à Paris)", "Echinococcus granulosus infection of thyroid", "Cleopatra Craft"));
        posts.add(new Post(5, "All-Star Superman", "Carcinoma in situ of skin of other and unspecified parts of face", "Dulce Tingly"));
        posts.add(new Post(6, "The Fearmakers", "Unspecified glaucoma", "Hy O'Downe"));
        posts.add(new Post(7, "Alice in Wonderland", "Volume depletion, unspecified", "Dorelia Huntar"));
        posts.add(new Post(8, "War Stories", "Syphilitic endocarditis of aortic valve", "Stillman Plumridge"));
        posts.add(new Post(9, "King of Ping Pong, The (Ping-pongkingen)", "Red cell aplasia (acquired)(adult)(with thymoma)", "Levi Woodruffe"));
        posts.add(new Post(10, "War of the Worlds, The", "Long-term (current) use of steroids", "Bendite Greer"));
        posts.add(new Post(11, "Luther the Geek", "Closed fracture of orbital floor (blow-out)", "Gert Leander"));
        posts.add(new Post(12, "Before I Go to Sleep", "Acute lymphoid leukemia, without mention of having achieved remission", "Falkner Dover"));
        posts.add(new Post(13, "Joanna", "Other calculus in bladder", "Ina Lapham"));
        posts.add(new Post(14, "Snow White and the Huntsman", "Blister of finger(s), without mention of infection", "Annabal Burstow"));
        posts.add(new Post(15, "Fuck", "Tuberculosis of other urinary organs, bacteriological or histological examination unknown (at present)", "Adolpho Hemphall"));
        posts.add(new Post(16, "Entre nos (Between Us)", "Accident to powered aircraft, other and unspecified, injuring other occupant of commercial aircraft (powered) in surface to surface transport", "Bail Lorrain"));
        posts.add(new Post(17, "Love unto Death (L'amour a mort)", "Vesicoureteral reflux with reflux nephropathy, unilateral", "Eddie Coners"));
        posts.add(new Post(18, "My Mom's New Boyfriend", "Total and subtotal cataract, congenital", "Riva Piscopello"));
        posts.add(new Post(19, "That Guy... Who Was in That Thing", "Interstitial myositis", "Hervey Woodland"));
        posts.add(new Post(20, "Shanghai Dreams (Qing hong)", "Thumb amputation status", "Cale Gosart"));
        posts.add(new Post(21, "Babbitt", "Poisoning by tricyclic antidepressants", "Gavra Seamons"));
        posts.add(new Post(22, "Bellflower", "Infertility, female, of unspecified origin", "Gasper Devigne"));
        posts.add(new Post(23, "Guest House Paradiso", "Excessive fetal growth, affecting management of mother, antepartum condition or complication", "Gan Hathorn"));
        posts.add(new Post(24, "Enough Said", "Vaginal hematoma", "Nelson Bielfelt"));
        posts.add(new Post(25, "Unfaithful, The", "Myopathy of extraocular muscles", "Ara Wikey"));
        posts.add(new Post(26, "Love Is News", "C5-C7 level with central cord syndrome", "Casper Emmanueli"));
        posts.add(new Post(27, "Resident Evil: Damnation", "Other extrapyramidal diseases and abnormal movement disorders", "Job Eisikovitsh"));
        posts.add(new Post(28, "High Strung", "Nephrotic syndrome with lesion of membranous glomerulonephritis", "Inge Shefton"));
        posts.add(new Post(29, "Triumph of Love, The", "Mosquito-borne hemorrhagic fever", "Anson Colvine"));
        posts.add(new Post(30, "Copying Beethoven", "Late effects of cerebrovascular disease, monoplegia of lower limb affecting dominant side", "Tasha Filipiak"));

        return posts;
    }
}
