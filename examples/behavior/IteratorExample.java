import java.util.Iterator;
import java.util.NoSuchElementException;

// Classe représentant un livre
class Livre {
    private String titre;

    public Livre(String titre) {
        this.titre = titre;
    }

    public String getTitre() {
        return titre;
    }
}

// Collection personnalisée de livres
class CollectionLivre implements Iterable<Livre> {
    private Livre[] livres;
    private int index = 0;

    public CollectionLivre(int taille) {
        livres = new Livre[taille];
    }

    public void ajouterLivre(Livre livre) {
        if (index < livres.length) {
            livres[index++] = livre;
        }
    }

    @Override
    public Iterator<Livre> iterator() {
        return new LivreIterator();
    }

    // Implémentation de l'Iterator
    private class LivreIterator implements Iterator<Livre> {
        private int position = 0;

        @Override
        public boolean hasNext() {
            return position < index;
        }

        @Override
        public Livre next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return livres[position++];
        }
    }
}

public class IteratorExample {
    public static void main(String[] args) {
        CollectionLivre collection = new CollectionLivre(3);
        collection.ajouterLivre(new Livre("Design Patterns"));
        collection.ajouterLivre(new Livre("Effective Java"));
        collection.ajouterLivre(new Livre("Clean Code"));

        for (Livre livre : collection) {
            System.out.println(livre.getTitre());
        }
    }
}