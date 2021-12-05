import com.project.card.CardList;
import com.project.category.CategoryLimit;
import com.project.item.ItemList;
import utilities.CommandLineProcessor;
import utilities.Commons;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainClass {
    private static final String configFilename = "categoryConfig.json";
    private static final String inventoryFilename = "Dataset - Sheet1.csv";
    private static final String outputFailedFileName = "failedOrders";
    private static final String cardChargedFileName = "cardCharged";

    public static void main(String[] args) {

        String orderFilename = CommandLineProcessor.getInstance().getInputFile(args);
        if("null".equals(orderFilename) || !Files.isReadable(Paths.get(orderFilename)) )
        {
            System.out.println("No such readable file exists on project path:"+orderFilename);
        }
        String failedoutput= outputFailedFileName + "_"+ orderFilename;
        String cardCharged= cardChargedFileName + "_"+ orderFilename;

        try {
            Files.deleteIfExists(Paths.get(failedoutput));
            Files.deleteIfExists(Paths.get(cardCharged));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Reading configuration files...");
        // setup categories
        CategoryLimit categoryLimit = Commons.loadCategories(configFilename);

        //setup inventory
        ItemList itemList = Commons.loadItems(inventoryFilename, categoryLimit.getItemCategory());

        System.out.println("Processing Order...");
        System.out.println("Reading File:" + orderFilename);

        // checking order file
        System.out.println("\nWriting failed orders to:" + failedoutput);
        CardList card = Commons.loadOrder(orderFilename, itemList, categoryLimit.getItemCategory(), failedoutput);

        //Output to file
        System.out.println("\nWriting card charged for order to:" + cardCharged);
        Commons.writeTotalAmountCharged(cardCharged, card);
    }


}
