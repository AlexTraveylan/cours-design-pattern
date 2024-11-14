Le Factory Pattern est un modèle de conception créational qui fournit une interface pour créer des objets dans une superclasse, tout en permettant aux sous-classes de modifier le type d'objets à créer. Ce modèle est particulièrement utile lorsque le processus de création nécessite du code complexe ou lorsque la classe instanciée dépend de la logique d'exécution.

Voici un exemple simple de Factory Pattern en Java :

1. **Création d'une interface ou d'une classe abstraite pour les produits** :

   ```java
   public interface Shape {
       void draw();
   }
   ```

2. **Création de plusieurs implémentations concrètes de cette interface** :

   ```java
   public class Circle implements Shape {
       @Override
       public void draw() {
           System.out.println("Inside Circle::draw() method.");
       }
   }

   public class Rectangle implements Shape {
       @Override
       public void draw() {
           System.out.println("Inside Rectangle::draw() method.");
       }
   }

   public class Square implements Shape {
       @Override
       public void draw() {
           System.out.println("Inside Square::draw() method.");
       }
   }
   ```

3. **Création de la classe Factory pour générer des objets de types concrets** :

   ```java
   public class ShapeFactory {

       // Utilisez la méthode getShape pour obtenir un objet de type Shape
       public Shape getShape(String shapeType) {
           if (shapeType == null) {
               return null;
           }
           if (shapeType.equalsIgnoreCase("CIRCLE")) {
               return new Circle();
           } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
               return new Rectangle();
           } else if (shapeType.equalsIgnoreCase("SQUARE")) {
               return new Square();
           }
           return null;
       }
   }
   ```

4. **Utilisation du Factory Pattern** :

   ```java
   public class FactoryPatternDemo {
       public static void main(String[] args) {
           ShapeFactory shapeFactory = new ShapeFactory();

           // Obtenez un objet Circle et appellez sa méthode draw
           Shape shape1 = shapeFactory.getShape("CIRCLE");
           shape1.draw();  // Output : Inside Circle::draw() method.

           // Obtenez un objet Rectangle et appellez sa méthode draw
           Shape shape2 = shapeFactory.getShape("RECTANGLE");
           shape2.draw();  // Output : Inside Rectangle::draw() method.

           // Obtenez un objet Square et appellez sa méthode draw
           Shape shape3 = shapeFactory.getShape("SQUARE");
           shape3.draw();  // Output : Inside Square::draw() method.
       }
   }
   ```

Dans cet exemple, `ShapeFactory` est utilisé pour créer différents objets `Shape` sans avoir à exposer la logique d'instanciation dans le code client. Cela permet d'ajouter de nouveaux types de formes sans modifier le code existant, ce qui respecte le principe Ouvert/fermé (OCP) de SOLID.