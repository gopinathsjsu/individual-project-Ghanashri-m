import com.project.card.CardList;
import com.project.category.CategoryLimit;
import com.project.item.ItemList;
import utilities.Commons;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainClass {
    private static final String configFilename = "categoryConfig.json";
    private static final String inventoryFilename = "inventory.txt";
    private static final String orderFilename = "order.csv";
    private static final String outputFailedFileName = "failedOrders.txt";
    private static final String cardChargedFileName = "cardCharged.csv";

    public static void main(String[] args) {
        try {
            Files.deleteIfExists(Paths.get(outputFailedFileName));
            Files.deleteIfExists(Paths.get(cardChargedFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Reading inputs...");
        // setup categories
        CategoryLimit categoryLimit = Commons.loadCategories(configFilename);

        //setup inventory
        ItemList itemList = Commons.loadItems(inventoryFilename, categoryLimit.getItemCategory());

        System.out.println("Processing Order...");
        // checking order file
        CardList card = Commons.loadOrder(orderFilename, categoryLimit, itemList, categoryLimit.getItemCategory(), outputFailedFileName);

        //Output to file

        Commons.writeTotalAmountCharged(cardChargedFileName, card);
    }


}
