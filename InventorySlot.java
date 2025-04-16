public class InventorySlot {
    private Item item;
    private int quantity;
    
    public InventorySlot(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;

    }

    public Item getItem() {
        return item;

    }

    public int getQuantity() {
        return quantity;

    }

    public void add(int amount) {
        quantity += amount;

    }

    public void remove(int amount) {
        quantity -= amount;
        
    }
}
