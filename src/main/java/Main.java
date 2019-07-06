import controllers.SuperGetController;
import interfaces.RequestListener;
import models.Product;
import org.jetbrains.annotations.NotNull;

public class Main
{
    public static void main(String[] args) {

        SuperGetController controller = SuperGetController.INSTANCE;

        controller.setApiKey("15b812e7081bcf23629a7ce6d7f2351ffe139d28");

        controller.getPrudectByBarcode("7290106656512", 10
                , new RequestListener() {
                    @Override
                    public <T> void onComplete(@NotNull T[] results) {
                        System.out.println("onComplete");

                        Product products = (Product) results[0];
                        System.out.println(products);

                    }

                    @Override
                    public void onError(@NotNull String message)
                    {
                        System.out.println("onError");
                        System.out.println(message);
                    }
                });

    }

}
