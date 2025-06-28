import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("El Quijote", "Cervantes", 39.99),
            new Book("Cien años de soledad", "Gabriel García Márquez", 45.50),
            new Book("Clean Code", "Robert C. Martin", 55.00),
            new Book("Effective Java", "Joshua Bloch", 70.00),
            new Book("The Pragmatic Programmer", "Andy Hunt", 65.00),
            new Book("Don Juan Tenorio", "José Zorrilla", 34.99),
            new Book("La sombra del viento", "Carlos Ruiz Zafón", 42.00),
            new Book("Rayuela", "Julio Cortázar", 48.75),
            new Book("Pedro Páramo", "Juan Rulfo", 38.25),
            new Book("El amor en los tiempos del cólera", "Gabriel García Márquez", 46.90),
            new Book("Crónica de una muerte anunciada", "Gabriel García Márquez", 41.00),
            new Book("La ciudad y los perros", "Mario Vargas Llosa", 49.99),
            new Book("Pantaleón y las visitadoras", "Mario Vargas Llosa", 44.50),
            new Book("1984", "George Orwell", 60.00),
            new Book("Un mundo feliz", "Aldous Huxley", 58.90),
            new Book("Fahrenheit 451", "Ray Bradbury", 53.25),
            new Book("Ensayo sobre la ceguera", "José Saramago", 47.80),
            new Book("La tregua", "Mario Benedetti", 39.00),
            new Book("Los detectives salvajes", "Roberto Bolaño", 52.20),
            new Book("El túnel", "Ernesto Sabato", 36.40),
            new Book("La invención de Morel", "Adolfo Bioy Casares", 37.00),
            new Book("Los renglones torcidos de Dios", "Torcuato Luca de Tena", 50.75),
            new Book("Sobre héroes y tumbas", "Ernesto Sabato", 45.10),
            new Book("Cuentos de la selva", "Horacio Quiroga", 33.30),
            new Book("El Aleph", "Jorge Luis Borges", 48.00),
            new Book("Ficciones", "Jorge Luis Borges", 51.10),
            new Book("Las venas abiertas de América Latina", "Eduardo Galeano", 43.00),
            new Book("Memoria del fuego", "Eduardo Galeano", 55.80),
            new Book("Viaje al centro de la Tierra", "Julio Verne", 38.70),
            new Book("20.000 leguas de viaje submarino", "Julio Verne", 42.25),
            new Book("La vuelta al mundo en 80 días", "Julio Verne", 40.00),
            new Book("Mujercitas", "Louisa May Alcott", 36.99),
            new Book("Orgullo y prejuicio", "Jane Austen", 39.90),
            new Book("Drácula", "Bram Stoker", 49.00),
            new Book("Frankenstein", "Mary Shelley", 41.80),
            new Book("Hamlet", "William Shakespeare", 46.00),
            new Book("Romeo y Julieta", "William Shakespeare", 44.99),
            new Book("El principito", "Antoine de Saint-Exupéry", 35.50),
            new Book("La metamorfosis", "Franz Kafka", 37.25),
            new Book("El proceso", "Franz Kafka", 43.75)
        );

        // Mostrar todos los libros
        books.stream().forEach(System.out::println);

        System.out.println("\n📘 Libros con precio mayor a $50:");
        books.stream()
            .filter(book -> book.getPrice() > 50)
            .forEach(System.out::println);

        System.out.println("\n Título de libros en mayúsculas:");
        books.stream()
            .map(book -> book.getTitle().toUpperCase())
            .forEach(System.out::println);

        
        System.out.println("\n💸 Libros con precio menor a $50:");
        List<Book> cheapBooks = books.stream()
            .filter(book -> book.getPrice() < 50)
            .collect(Collectors.toList());

        cheapBooks.forEach(System.out::println);

        System.out.println("\n💰 Precio total de todos los libros:");
        double totalPrice = books.stream()
            .map(Book::getPrice)
            .reduce(0.0, (a, b) -> a + b);

        System.out.println("Total: $" + totalPrice);

        System.out.println("\n🔎 ¿Hay algún libro de Robert C. Martin?");
        boolean hasMartin = books.stream()
            .anyMatch(book -> book.getAuthor().equals("Robert C. Martin"));

        System.out.println("Resultado: " + (hasMartin ? "Sí, hay al menos uno." : "No, no hay ninguno."));


        System.out.println("\n📚 Títulos únicos de libros:");
        List<String> titles = books.stream()
            .map(Book::getTitle)
            .distinct()
            .collect(Collectors.toList());

        titles.forEach(System.out::println);

        System.out.println("\n📖 Primeros 5 libros (usando limit):");
        books.stream()
            .limit(5)
            .forEach(System.out::println);

        System.out.println("\n➡️ Libros omitidos (saltando los primeros 5):");
        books.stream()
            .skip(5)
            .forEach(System.out::println);

        System.out.println("\n💵 Libros ordenados por precio (menor a mayor):");
        books.stream()
            .sorted(Comparator.comparing(Book::getPrice))
            .forEach(System.out::println);






    }
}
