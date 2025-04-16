public class Item {
    private String name;
    private String description;
    private boolean isStackable;

    public Item(String name, String description, boolean isStackable) {
        this.name = name;
        this.description = description;
        this.isStackable = isStackable;

    }

    public String getName() {
        return name;

    }

    public String getDescription() {
        return description;

    }

    public boolean isStackable() {
        return isStackable;
        
    }

    public void printDetails() {
        System.out.println(name + ": " + description);
        
    }
}