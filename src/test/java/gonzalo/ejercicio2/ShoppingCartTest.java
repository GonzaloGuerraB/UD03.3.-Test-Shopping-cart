package gonzalo.ejercicio2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {

	ShoppingCart cart;
	Product product;
	
	@BeforeEach
    void setUp() {
		cart = new ShoppingCart();
		product = new Product("Test Product", 19.99);
	}
	
	@AfterEach
    void tearDown() {
        cart = null;
        product = null;
    }
	
    @Test
    public void testInitialItemCount() {
        assertEquals(0, cart.getItemCount());
    }

    @Test
    public void testEmptyCartItemCount() {
        cart.empty();
        assertEquals(0, cart.getItemCount());
    }

    @Test
    public void testAddItem(){
     
        cart.addItem(product);
        assertEquals(1, cart.getItemCount());
        
    }
    
    @Test
    public void testAddItemBalance() {
        
    	double beforePrice = cart.getBalance();
    	cart.addItem(product);
    	double afterPrice = cart.getBalance();
        assertEquals(afterPrice, product.getPrice() + beforePrice);
    
        
    }

    @Test
    public void testRemoveItem() throws ProductNotFoundException {
      
        cart.addItem(product);
        cart.removeItem(product);
        assertEquals(0, cart.getItemCount());
        
    }

    @Test
    public void testRemoveItemNotFound() {

        assertThrows(ProductNotFoundException.class, () -> {
            cart.removeItem(product);
        });
    }

    @Test
    public void testRemoveItemNotFoundWithFail() {
        try {
            cart.removeItem(product);
            fail("Expected ProductNotFoundException");
        } catch (ProductNotFoundException e) {
        }
    }
}
