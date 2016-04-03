package project.scu.edu.chew.helpers;

/**
 * Created by lakshitha on 2/2/16.
 */
import java.util.List;

import project.scu.edu.chew.models.FoodItem;
import project.scu.edu.chew.models.HomeCook;


// Helper class to load data - to be replaced with database laster.
public class LoadData {


    public static void populateData(List<HomeCook> homeCooks) {

        // #ITALIAN STARTS ************************************************************************************************
        HomeCook homeCook = new HomeCook("Maria's Kitchen", "408-555-9012", "pasta.jpg");
        homeCook.setCuisine("Italian");
        homeCook.setRating(3.5f);
        homeCook.setLargeImage("main_kitchen1");
        homeCook.setAddress("1600 Amphitheatre Pkwy, Mountain View, CA 94043");
        homeCook.setTime("9:00AM - 1:00PM, 5:00PM - 10:00PM");

        homeCook.getHsvList().add("chickenph1");
        homeCook.getHsvList().add("tiramisuh1");
        homeCook.getHsvList().add("chickenph2");
        homeCook.getHsvList().add("pastah3");
        homeCook.getHsvList().add("lasagnah1");
        homeCook.getHsvList().add("mnch1");
        homeCook.getHsvList().add("chickenph3");
        homeCook.getHsvList().add("mnch2");
        homeCook.getHsvList().add("pastah1");
        homeCook.getHsvList().add("pastah2");
        homeCook.getHsvList().add("pizzah1");
        homeCook.getHsvList().add("tiramisuh2");
        homeCook.getHsvList().add("pastah5");
        //#1
        FoodItem foodItem = new FoodItem("Pizza", "pizzam1");
        foodItem.setDescription("With mozzarella roasted red peppers and basil with alfredo and garlic spread ");
        foodItem.setPrice(10.50);
        foodItem.setServing("2-4");
        foodItem.setReadyTime("20");
        foodItem.setLongDescription(" Pizza is a flatbread generally topped with tomato sauce and cheese and baked in an oven. " +
                "It is commonly topped with a selection of meats, vegetables and condiments.");
        foodItem.getNutritionTable().put("Calories", "285g");
        foodItem.getNutritionTable().put("Carbohydrates", "36g");
        foodItem.getNutritionTable().put("Protein", "4g");
        foodItem.getNutritionTable().put("Fat", "10g");
        foodItem.getNutritionTable().put("Fiber", "2.5g");
        homeCook.getFoodItems().add(foodItem);

        //#2
        foodItem = new FoodItem("Pasta", "pastam1");
        foodItem.setDescription("Ziti, Prosciutto, Asiago Cheese & Red Pepper Cream Sauce");
        foodItem.setPrice(8.50);
        foodItem.setServing("1-2");
        foodItem.setReadyTime("25");
        foodItem.setLongDescription(" Pasta is a staple food of traditional italian cusine, with the first reference dating to " +
                "1154 in Sicily. It is also commonly used to refer to variety of dishes. Typically, pasta is a noodle made from an " +
                "inleavened dough of a durum wheat flour mixed with water or eggs and formed into sheets of various shapes, then " +
                "cooked by boiling or baking. It can also be made with flour from other cerelas or grains.Pastas can be divided " +
                "into two broad categories, dried and fresh.");
        foodItem.getNutritionTable().put("Calories", "200g");
        foodItem.getNutritionTable().put("Carbohydrates", "30g");
        foodItem.getNutritionTable().put("Protein", "4g");
        foodItem.getNutritionTable().put("Fat", "10g");
        foodItem.getNutritionTable().put("Fiber", "5g");
        homeCook.getFoodItems().add(foodItem);

        //#3
        foodItem = new FoodItem("Lasagna", "lasagna1");
        foodItem.setDescription("Layered lasagne noodles, italian sausage and beef, ricotta cheese, tomato sauce and baked mozzarella and romano cheese");
        foodItem.setPrice(11.40);
        foodItem.setServing("3-4");
        foodItem.setReadyTime("90");
        foodItem.setLongDescription("Layer upon layer of soft buttery pasta with the delicious combination of juicy " +
                "seasoned tomatoes mixed with ground meat perfectly seasoned with softened onions with just the right amount of " +
                "cottage cheese. All mixed perfectly together with hot, cheesy mozzarella cheese topped with a crunchy Parmesan " +
                "cheese crust.");
        foodItem.getNutritionTable().put("Calories", "377g");
        foodItem.getNutritionTable().put("Carbohydrates", "38.2g");
        foodItem.getNutritionTable().put("Protein", "24.4g");
        foodItem.getNutritionTable().put("Fat", "40g");
        foodItem.getNutritionTable().put("Fiber", "2.1g");
        homeCook.getFoodItems().add(foodItem);

        //#4
        foodItem = new FoodItem("Tiramisu", "tiramisum1");
        foodItem.setServing("1-2");
        foodItem.setReadyTime("20");
        foodItem.setDescription("Traditional Italian coffee cake- lady fingers dipped in expresso layered with marscapone cream and topped with cocca powder");
        foodItem.setPrice(3.50);
        foodItem.setLongDescription("A dessert of cake infused with a liquid such as coffee or rum, layered with " +
                "mascarpone cheese, andtopped with cocoa or grated chocolate.");
        foodItem.getNutritionTable().put("Calories", "601g");
        foodItem.getNutritionTable().put("Carbohydrates", "34.4g");
        foodItem.getNutritionTable().put("Protein", "7.8g");
        foodItem.getNutritionTable().put("Fat", "45.8g");
        foodItem.getNutritionTable().put("Fiber", "0.4g");
        homeCook.getFoodItems().add(foodItem);

        //#5
        foodItem = new FoodItem("Chicken Parmigiana", "chickenp1");
        foodItem.setDescription("Mama’s tomato sauce, lightly fried chicken breast, roman and mozzerella cheese baked untill its golden brown");
        foodItem.setPrice(13.30);
        foodItem.setServing("2-3");
        foodItem.setReadyTime("50");
        foodItem.setLongDescription("It consists of a breaded chicken breast topped with tomato sauce and " +
                "mozzarella, parmesan or provolone cheese. A slice of ham or bacon is sometimes added. It is based on a " +
                "combination of the Italian melanzane alla Parmigiana, a dish using breaded eggplantslices instead of chicken, " +
                "along with costelette Parmigiana");
        foodItem.getNutritionTable().put("Calories", "433g");
        foodItem.getNutritionTable().put("Carbohydrates", "28g");
        foodItem.getNutritionTable().put("Protein", "25g");
        foodItem.getNutritionTable().put("Fat", "25g");
        foodItem.getNutritionTable().put("Fiber", "0.4g");
        homeCook.getFoodItems().add(foodItem);

        //#6
        foodItem = new FoodItem("Macaroni and Cheese", "macnc1");
        foodItem.setDescription("Elbow macaroni and yellow cheese");
        foodItem.setPrice(7.80);
        foodItem.setServing("1-2");
        foodItem.setReadyTime("25");
        foodItem.setLongDescription("macaroni, or some other tube-shaped pasta, layered with cheese and cooked with milk or cream.");
        foodItem.getNutritionTable().put("Calories", "326g");
        foodItem.getNutritionTable().put("Carbohydrates", "39g");
        foodItem.getNutritionTable().put("Protein", "14g");
        foodItem.getNutritionTable().put("Fat", "13g");
        foodItem.getNutritionTable().put("Fiber", "2.8g");
        homeCook.getFoodItems().add(foodItem);

        homeCooks.add(homeCook);
        //ITALIAN ENDS


        //INDIAN STARTS ************************************************************************************************
        homeCook = new HomeCook("Swathi’s Kitchen", "408-984-9922", "paratha.jpg");
        homeCook.setLargeImage("swathi_kitchen");
        homeCook.setCuisine("Indian");
        homeCook.setAddress("1842 N Shoreline Blvd, Mountain View, CA 94043");
        homeCook.setTime("9:00 am to 10:00 pm");
        homeCook.setRating(4.5f);

        homeCook.getHsvList().add("daalh1");
        homeCook.getHsvList().add("parathah1");
        homeCook.getHsvList().add("biryanih1");
        homeCook.getHsvList().add("dosah1");
        homeCook.getHsvList().add("saag_paneer");
        homeCook.getHsvList().add("dosa");
        homeCook.getHsvList().add("rice_and_curry");
        homeCook.getHsvList().add("daal");
        homeCook.getHsvList().add("chickentikka_masala");
        homeCook.getHsvList().add("chicken_biryani");

        //#1
        foodItem = new FoodItem("Saag Paneer", "ppaneerm1");
        foodItem.setDescription("Spinach cooked with herbs, spices and traditional indian cheese");
        foodItem.setPrice(11.99);
        foodItem.setLongDescription("Saag paneer is a classic Indian dish of cooked spinach studded with cubes of fried " +
                "paneer cheese. Thickened with cream or coconut milk, it's a hearty and filling vegetarian meal.");
        foodItem.getNutritionTable().put("Calories", "194");
        foodItem.getNutritionTable().put("Carbohydrates", "27.1g");
        foodItem.getNutritionTable().put("Protein", "14.6g");
        foodItem.getNutritionTable().put("Fat", "10g");
        foodItem.getNutritionTable().put("Fiber", "6.6g");
        foodItem.setServing("2-3");
        foodItem.setReadyTime("40");
        homeCook.getFoodItems().add(foodItem);

        //#2
        foodItem = new FoodItem("Dosa", "dosam1");
        foodItem.setDescription("stuffed with fillings of vegetables and served with sambar and chutney.");
        foodItem.setPrice(5.50);
        foodItem.setLongDescription("Dosa is a fermented crepe made from rice batter and black lentils.Sambar is a " +
                "lentil-based vegetable stew or chowder based on a broth made with tamarind ");
        foodItem.getNutritionTable().put("Calories", "106");
        foodItem.getNutritionTable().put("Carbohydrates", "21.24g");
        foodItem.getNutritionTable().put("Protein", "2.15g");
        foodItem.getNutritionTable().put("Fat", "1.04g");
        foodItem.getNutritionTable().put("Fiber", "0.8g");
        foodItem.setServing("1");
        foodItem.setReadyTime("25");
        homeCook.getFoodItems().add(foodItem);

        //#3
        foodItem = new FoodItem("Rice and Curry", "rncm1");
        foodItem.setDescription("Large bowl of rice served with vegetable curry of your choice.");
        foodItem.setPrice(8.30);
        foodItem.setLongDescription("A large bowl of rice, most often boiled, but frequently fried. A vegetable curry, " +
                "perhaps of green beans, jackfruit or leeks. ");
        foodItem.getNutritionTable().put("Calories", "403");
        foodItem.getNutritionTable().put("Carbohydrates", "55.5g");
        foodItem.getNutritionTable().put("Protein", "4.3g");
        foodItem.getNutritionTable().put("Fat", "9.1g");
        foodItem.getNutritionTable().put("Fiber", "6.7g");
        foodItem.setServing("3");
        foodItem.setReadyTime("45");
        homeCook.getFoodItems().add(foodItem);

        //#4
        foodItem = new FoodItem("Daal", "daalm1");
        foodItem.setDescription("Black lentils and kidney beans in a savory tomato anion sauce.");
        foodItem.setPrice(4.50);
        foodItem.setLongDescription(" Thick Spicy stew made form lentils, dal and similar legumes and similar legumes .");
        foodItem.getNutritionTable().put("Calories", "198");
        foodItem.getNutritionTable().put("Carbohydrates", "26.18 g");
        foodItem.getNutritionTable().put("Protein", "10.36g");
        foodItem.getNutritionTable().put("Fat", "6.32g");
        foodItem.getNutritionTable().put("Fiber", "8.7g");
        foodItem.setServing("2");
        foodItem.setReadyTime("20");
        homeCook.getFoodItems().add(foodItem);

        //#5
        foodItem = new FoodItem("Chicken Tikka Masala", "chickentm1");
        foodItem.setDescription("Breast meat barbecued in tandoor oven, then cooked with bell pepper, onion, garlic, ginger, tomatoes, cream, and spices.");
        foodItem.setPrice(10.50);
        foodItem.setLongDescription("Chicken tikka masala is chicken tikka, chunks of chicken marinated in " +
                "spices and yogurt, that is then baked in a tandoor oven, and served in a masala (spice mix) sauce. The sauce " +
                "usually includes tomatoes (frequently as purée), cream, coconut cream and various spices. The sauce or " +
                "chicken pieces (or both) are coloured orange using foodstuffs such as turmeric powder, paprika powder or tomato puree.");
        foodItem.getNutritionTable().put("Calories", "849");
        foodItem.getNutritionTable().put("Carbohydrates", "105 g");
        foodItem.getNutritionTable().put("Protein", "29g");
        foodItem.getNutritionTable().put("Fat", "35g");
        foodItem.getNutritionTable().put("Fiber", "7g");
        foodItem.setServing("2-3");
        foodItem.setReadyTime("30");
        homeCook.getFoodItems().add(foodItem);

        //#6
        foodItem = new FoodItem("Chicken Biryani", "chickenbm1");
        foodItem.setDescription("Fragrant long-grained rice is layered with meat that have been cooked in a mixture of spices.");
        foodItem.setPrice(13.25);
        foodItem.setLongDescription("The  biryani is light, less spicy and is easy to digest. Mutton is " +
                "the most common meat used, although beef, chicken, fish and prawns are also sometimes used. " +
                "The basmati rice is cooked separately and flavoured with ghee and spices like star anise, cinnamon, " +
                "cardamon and cloves.");
        foodItem.getNutritionTable().put("Calories", "548");
        foodItem.getNutritionTable().put("Carbohydrates", "48g");
        foodItem.getNutritionTable().put("Protein", "19g");
        foodItem.getNutritionTable().put("Fat", "25g");
        foodItem.getNutritionTable().put("Fiber", "3g");
        foodItem.setServing("3-4");
        foodItem.setReadyTime("90");
        homeCook.getFoodItems().add(foodItem);

        homeCooks.add(homeCook);
        //INDIAN ENDS


        //AMERICAN ************************************************************************************************
        homeCook = new HomeCook("Albert's kitchen", "650-444-0320", "food12.jpg");
        homeCook.setCuisine("American");
        homeCook.setLargeImage("americankitchen");
        homeCook.setAddress("1690 S Bascom Ave, Campbell, CA");
        homeCook.setTime("9:00 am to 10:00 pm");
        homeCook.setRating(2.5f);

        homeCook.getHsvList().add("breadh1");
        homeCook.getHsvList().add("burgerh1");
        homeCook.getHsvList().add("omeletteh1");
        homeCook.getHsvList().add("omletteh2");
        homeCook.getHsvList().add("omletteh3");
        homeCook.getHsvList().add("saladh1");
        homeCook.getHsvList().add("saladh2");
        homeCook.getHsvList().add("saladh3");

        //#1
        foodItem = new FoodItem("Blueberry pancakes", "blueberrypm1");
        foodItem.setDescription("Buttermilk pancakes filled with plump blueberries and lightly dusted with powdered sugar. " +
                "Served with whipped butter and hot blueberry compote.");
        foodItem.setPrice(4.30);
        foodItem.setServing("1-2");
        foodItem.setReadyTime("20");
        foodItem.setLongDescription(" A pancake is a flat cake, often thin, and round, prepared from a starch-based " +
                "batter that may also contain eggs, milk and butter and cooked on a hot surface such as a griddle or frying pan, " +
                "often with oil or butter");
        foodItem.getNutritionTable().put("Calories", "64g");
        foodItem.getNutritionTable().put("Carbohydrates", "8g");
        foodItem.getNutritionTable().put("Protein", "1.8g");
        foodItem.getNutritionTable().put("Fat", "2.7g");
        foodItem.getNutritionTable().put("Fiber", "1.1g");
        homeCook.getFoodItems().add(foodItem);

        //#2
        foodItem = new FoodItem("Chicken Fajita Omelette", "omlettem1");
        foodItem.setDescription("Filled with grilled fajita-seasoned chicken breast strips, fresh onions and " +
                "green peppers with salsa, and a blend of cheeses. ");
        foodItem.setPrice(12.50);
        foodItem.setServing("2-3");
        foodItem.setReadyTime("30");
        foodItem.setLongDescription("Fajitas were traditionally made with grilled skirt steak, though now they can be " +
                "made with chicken, shrimp, you name it. The method is to quickly sear the meat on a griddle or grill, slice " +
                "and serve with quickly seared peppers and onions and flour tortillas.");
        foodItem.getNutritionTable().put("Calories", "959g");
        foodItem.getNutritionTable().put("Carbohydrates", "22g");
        foodItem.getNutritionTable().put("Protein", "19g");
        foodItem.getNutritionTable().put("Fat", "65g");
        foodItem.getNutritionTable().put("Fiber", "4g");
        homeCook.getFoodItems().add(foodItem);


        //#3
        foodItem = new FoodItem("Chicken Burger", "burgerm1");
        foodItem.setDescription("Tender, juicy breast meat grilled to perfection, served with crisp lettuce, juicy " +
                "tomato and mayonnaise on a toasted, buttered bun.");
        foodItem.setPrice(3.90);
        foodItem.setServing("1");
        foodItem.setReadyTime("15");
        foodItem.setLongDescription("A chciken burger that typically consists of a boneless, skinless breast of " +
                "chicken served between slices of bread, on a bun, or on a roll.");
        foodItem.getNutritionTable().put("Calories", "239g");
        foodItem.getNutritionTable().put("Carbohydrates", "19.2g");
        foodItem.getNutritionTable().put("Protein", "18.68g");
        foodItem.getNutritionTable().put("Fat", "9.15g");
        foodItem.getNutritionTable().put("Fiber", "0.8g");
        homeCook.getFoodItems().add(foodItem);

        //#4
        foodItem = new FoodItem("Citrus Chicken Pecan Salad", "saladm1");
        foodItem.setDescription("Juicy grilled chicken, plump orange segments & crunchy candied pecans on a bed of crisp mixed greens. Tossed in our zesty orange vinaigrette and made-to-order.");
        foodItem.setPrice(7.50);
        foodItem.setServing("1-2");
        foodItem.setReadyTime("10");
        foodItem.setLongDescription("A salad is a dish consisting of small pieces of food, which may be mixed with a sauce " +
                "or salad dressing. They are typically served cold. Salads can incorporate a variety of foods including vegetables, " +
                "fruits, cheese, cooked meat, eggs and grains. Garden salads use a base of leafy greens; they are common enough " +
                "that the word salad alone often refers specifically to garden salads. Other types include bean salad, tuna salad, " +
                "fattoush, Greek salad, and somen salad. The sauce used to flavor a salad is commonly called a salad dressing; " +
                "well-known types include ranch, Thousand Island, and vinaigrette.");
        foodItem.getNutritionTable().put("Calories", "660g");
        foodItem.getNutritionTable().put("Carbohydrates", "43g");
        foodItem.getNutritionTable().put("Protein", "35g");
        foodItem.getNutritionTable().put("Fat", "42g");
        foodItem.getNutritionTable().put("Fiber", "7g");
        homeCook.getFoodItems().add(foodItem);

        homeCooks.add(homeCook);
        //AMERICAN ENDS


        //MEXICAN ************************************************************************************************
        homeCook = new HomeCook("Liliana's kitchen", "312-623-7446", "tacos.jpg");
        homeCook.setCuisine("Mexican");
        homeCook.setLargeImage("mexicankitchen");
        homeCook.setAddress("1105 W El Camino Real, Sunnyvale, CA 94087");
        homeCook.setTime("9:00 am to 10:00 pm");
        homeCook.setRating(3.5f);

        homeCook.getHsvList().add("burritoh1");
        homeCook.getHsvList().add("chickenh1");
        homeCook.getHsvList().add("enchiladash1");
        homeCook.getHsvList().add("burritoh2");
        homeCook.getHsvList().add("flanh1");
        homeCook.getHsvList().add("nachosh1");
        homeCook.getHsvList().add("quesoh1");
        homeCook.getHsvList().add("chickenh2");
        homeCook.getHsvList().add("quessadilah1");
        homeCook.getHsvList().add("tacosh1");

        //#1
        foodItem = new FoodItem("Burrito", "burritom1");
        foodItem.setDescription("fire grilled chicken or Baja shrimp , rice, pinto beans, pico de gallo salsa, " +
                "sour cream, fresh cilantro, melted jack cheese and a smoky chipotle salsa roja rolled in a grilled tortilla.");
        foodItem.setPrice(8.50);
        foodItem.setServing("1-2");
        foodItem.setReadyTime("20");
        foodItem.setLongDescription("A burrito is a type of Mexican and Tex-Mex food, consisting of a wheat " +
                "flour tortilla wrapped or folded into a cylindrical shape to completely enclose the filling.");
        foodItem.getNutritionTable().put("Calories", "447g");
        foodItem.getNutritionTable().put("Carbohydrates", "71g");
        foodItem.getNutritionTable().put("Protein", "14g");
        foodItem.getNutritionTable().put("Fat", "13g");
        foodItem.getNutritionTable().put("Fiber", "1.2g");
        homeCook.getFoodItems().add(foodItem);

        //#2
        foodItem = new FoodItem("Tacos", "tacosm1");
        foodItem.setDescription("Cheese, meat choice, de gallo, guacamole sour cream,salso on soft corn tortilla. ");
        foodItem.setPrice(2.70);
        foodItem.setServing("1-2");
        foodItem.setReadyTime("10");
        foodItem.setLongDescription("A taco is a traditional Mexican dish composed of a corn or wheat " +
                "tortilla folded or rolled around a filling. are made of thin pork steaks seasoned with adobo seasoning, " +
                "then skewered and overlapped on one another on a vertical rotisserie cooked and flame-broiled as it spins.");
        foodItem.getNutritionTable().put("Calories", "156g");
        foodItem.getNutritionTable().put("Carbohydrates", "14g");
        foodItem.getNutritionTable().put("Protein", "6g");
        foodItem.getNutritionTable().put("Fat", "9g");
        foodItem.getNutritionTable().put("Fiber", "2.7g");
        homeCook.getFoodItems().add(foodItem);

        //#3
        foodItem = new FoodItem("Enchiladas", "enchiladasm1");
        foodItem.setDescription("Dipped tortilla in red sauce and fried filled with your choice of fillings ");
        foodItem.setPrice(6.50);
        foodItem.setServing("2-3");
        foodItem.setReadyTime("30");
        foodItem.setLongDescription("A tortilla rolled and stuffed usually with a mixture containing meat or cheese and " +
                "served with a sauce , refried beans and spanish rice");
        foodItem.getNutritionTable().put("Calories", "323g");
        foodItem.getNutritionTable().put("Carbohydrates", "30g");
        foodItem.getNutritionTable().put("Protein", "6g");
        foodItem.getNutritionTable().put("Fat", "12g");
        foodItem.getNutritionTable().put("Fiber", "6g");
        homeCook.getFoodItems().add(foodItem);

        //#4
        foodItem = new FoodItem("Chicken Quesadilla ", "quessadilam1");
        foodItem.setDescription("Flour tortillas filled with mixed cheeses, pico de gallo and chicken. They are " +
                "grilled to order and served with choice of sour cream or guacamole or both.");
        foodItem.setPrice(10.20);
        foodItem.setServing("2-3");
        foodItem.setReadyTime("40");
        foodItem.setLongDescription("A quesadilla is a wheat tortilla or a corn tortilla filed with cheese, a savory mixture, " +
                "shredded chicken often cooked on a griddle then folded in half to form a half moon shape.");
        foodItem.getNutritionTable().put("Calories", "528g");
        foodItem.getNutritionTable().put("Carbohydrates", "30g");
        foodItem.getNutritionTable().put("Protein", "6g");
        foodItem.getNutritionTable().put("Fat", "12g");
        foodItem.getNutritionTable().put("Fiber", "6g");
        homeCook.getFoodItems().add(foodItem);


        //#5
        foodItem = new FoodItem("Oaxacan Coconut Flan", "flanm1");
        foodItem.setDescription("This community-size flan uses cream of coconut and toasted coconut to give it tropical flavor.");
        foodItem.setPrice(5.40);
        foodItem.setServing("1-2");
        foodItem.setReadyTime("20");
        foodItem.setLongDescription("Coconut Flan is a variation on a sweet custard dessert that is popular " +
                "throughout Latin American and Europe. It is a simple yet elegant finale to any meal.");
        foodItem.getNutritionTable().put("Calories", "540g");
        foodItem.getNutritionTable().put("Carbohydrates", "59g");
        foodItem.getNutritionTable().put("Protein", "11g");
        foodItem.getNutritionTable().put("Fat", "30g");
        foodItem.getNutritionTable().put("Fiber", "1g");
        homeCook.getFoodItems().add(foodItem);

        //#6
        foodItem = new FoodItem("Chile Con Queso", "quesom1");
        foodItem.setDescription("Cheese melted with tomatoes onions and spices.");
        foodItem.setPrice(8.70);
        foodItem.setServing("1-2");
        foodItem.setReadyTime("30");
        foodItem.setLongDescription("Chile Con Queso is a smooth, creamy sauce, used for dipping that is made from a blend " +
                "of melted cheeses, cream and chili peppers. Chili peppers are sometimes replaced with canned tomatoes.");
        foodItem.getNutritionTable().put("Calories", "351g");
        foodItem.getNutritionTable().put("Carbohydrates", "10g");
        foodItem.getNutritionTable().put("Protein", "6g");
        foodItem.getNutritionTable().put("Fat", "2g");
        foodItem.getNutritionTable().put("Fiber", "0.5g");
        homeCook.getFoodItems().add(foodItem);

        //#7
        foodItem = new FoodItem("Super Nachos", "nachosm1");
        foodItem.setDescription("Tortilla chips topeed with beaf,beans and cheese sauce covered with lettuce, tomatoes and sour cream.");
        foodItem.setPrice(8.70);
        foodItem.setServing("1-2");
        foodItem.setReadyTime("25");
        foodItem.setLongDescription("Super Nachos is an appetizer , originally made by putting thick, round slices of jalapeno peppers and melted cheese on tortilla chips. Also includes diced tomatoes and onion, diced avacado, chopped olives and salsa.");
        foodItem.getNutritionTable().put("Calories", "346g");
        foodItem.getNutritionTable().put("Carbohydrates", "36g");
        foodItem.getNutritionTable().put("Protein", "9g");
        foodItem.getNutritionTable().put("Fat", "19g");
        foodItem.getNutritionTable().put("Fiber", "5g");
        homeCook.getFoodItems().add(foodItem);

        homeCooks.add(homeCook);
        //MEXICAN ENDS


        //CHINESE ************************************************************************************************
        homeCook = new HomeCook("Wang's Kitchen", "408-433-9626", "food1.jpg");
        homeCook.setLargeImage("chinesekitchen");
        homeCook.setCuisine("Chinese");
        homeCook.setAddress("50 University Ave #260, Los Gatos, CA 95030");
        homeCook.setTime("11:30 am to 10:00 pm");
        homeCook.setRating(3.0f);

        homeCook.getHsvList().add("manchow_soup");
        homeCook.getHsvList().add("wonton_soup");
        homeCook.getHsvList().add("spring_roll");
        homeCook.getHsvList().add("calamari");
        homeCook.getHsvList().add("sizzler");
        homeCook.getHsvList().add("sfried_rice");
        homeCook.getHsvList().add("hakka_noodles");
        homeCook.getHsvList().add("chowmein");
        homeCook.getHsvList().add("riceh1");
        homeCook.getHsvList().add("sizzlerh1");
        homeCook.getHsvList().add("souph1");
        homeCook.getHsvList().add("souph2");

        //#1
        foodItem = new FoodItem("Manchow soup", "manchowm1");
        foodItem.setDescription("Moderately Spiced chicken and vegetable broth topped with crispy noodles");
        foodItem.setPrice(9.99);
        foodItem.setServing("1-2");
        foodItem.setReadyTime("25");
        foodItem.setLongDescription("Manchow soup is a soup popular in Indian Chinese cuisine due to its ease of " +
                "preparation and hot spicy taste. It is available in large restaurants and street food carts alike." +
                " Although the soup is named after Manchuria it does not resemble any that is normally found in the cuisines of " +
                "the region. It is a dark brown soup prepared with various vegetables, scallions, and chicken (in the non-vegetarian " +
                "version only), thickened with stock and corn flour, and flavored with relatively generous doses of soy sauce, salt, " +
                "garlic and chili peppers. It may also be garnished with chopped spring onions, and served with crispy dry noodles.");
        foodItem.getNutritionTable().put("Calories", "115");
        foodItem.getNutritionTable().put("Carbohydrates", "6.8g");
        foodItem.getNutritionTable().put("Protein", "9.8g");
        foodItem.getNutritionTable().put("Fat", "5.5g");
        foodItem.getNutritionTable().put("Fiber", "1.2g");
        homeCook.getFoodItems().add(foodItem);

        //#2
        foodItem = new FoodItem("Chicken Wonton Soup", "wontonm1");
        foodItem.setDescription("Home Made Chicken wontons in a delicate clear soup");
        foodItem.setPrice(9.99);
        foodItem.setServing("1-2");
        foodItem.setReadyTime("25");
        foodItem.setLongDescription("Wonton filling is essentially stir-fry, but with smaller particles and less cooking. " +
                "It goes hot into a wonton wrapper (equal to 1/4 of an egg roll wrapper), which is then cooked in a hot broth. " +
                "Note that these wontons do not contain cabbage and carrots, which are used by commercial wonton producers to " +
                "cheapen the filling. The filling in these wontons is superior.Made as a water-based soup, this soup combines " +
                "meat and pasta in a soothing chicken broth. Chicken Wonton Soup, or Chicken Won Ton as it may also be referred, " +
                "is a soup that contains cooked chicken meat, thick dumpling-like pasta, celery, spinach or herbs, and flavorings " +
                "that are added to a chicken stock. This soup goes well with lunch, dinner or Asian inspired meals, events and " +
                "celebrations.");
        foodItem.getNutritionTable().put("Calories", "181");
        foodItem.getNutritionTable().put("Carbohydrates", "7.08g");
        foodItem.getNutritionTable().put("Protein", "15g");
        foodItem.getNutritionTable().put("Fat", "14.24g");
        foodItem.getNutritionTable().put("Fiber", "1g");
        homeCook.getFoodItems().add(foodItem);

        //#3
        foodItem = new FoodItem("Chicken spring roll", "springrollm1");
        foodItem.setDescription("Spring rolls stuffed with julienne of vegetables, chicken and fried");
        foodItem.setPrice(5.99);
        foodItem.setServing("1-2");
        foodItem.setReadyTime("15");
        foodItem.setLongDescription("Spring rolls are a large variety of filled, rolled appetizers or dim sum found in " +
                "East Asian and Southeast Asian cuisine. The name is a literal translation of the " +
                "Chinese chūn juǎn (春卷 'spring roll'). The kind of wrapper, fillings, and cooking technique used, " +
                "as well as the name, vary considerably within this large area, depending on the region's culture.n " +
                "Chinese cuisine, spring rolls are savoury rolls with cabbage and other vegetable fillings inside a wrapped " +
                "cylinder shaped thin pastry. From areas such as Zhejiang in eastern China, and northern China. They are usually " +
                "eaten during the Spring Festival in mainland China, hence the name. Meat varieties, particularly pork are also " +
                "popular. Fried spring rolls are generally small and crisp. They can be sweet or savory; the latter are typically " +
                "prepared with vegetables. This version is fully wrapped before being pan-fried or deep-fried.");
        foodItem.getNutritionTable().put("Calories", "65");
        foodItem.getNutritionTable().put("Carbohydrates", "7.12g");
        foodItem.getNutritionTable().put("Protein", "3.03g");
        foodItem.getNutritionTable().put("Fat", "2.61g");
        foodItem.getNutritionTable().put("Fiber", "0.5g");
        homeCook.getFoodItems().add(foodItem);

        //#4
        foodItem = new FoodItem("Golden fried calamari", "calamarim1");
        foodItem.setDescription("Batter fried calamari strips");
        foodItem.setPrice(10.99);
        foodItem.setServing("2-3");
        foodItem.setReadyTime("20");
        foodItem.setLongDescription("Squid is a popular food in many parts of the world. Calamari is a culinary name for " +
                "squid, especially for dishes from the Mediterranean, notably fried squid (fried calamari). There are many " +
                "ways of preparing and cooking squid, with every country and region having its own recipes.Fried squid " +
                "(fried calamari, calamari) is a dish in Mediterranean cuisine. It consists of batter-coated, deep fried " +
                "squid, fried for less than two minutes to prevent toughness. It is served plain, with salt and lemon on the " +
                "side.In North America, it is a staple in seafood restaurants. It is served as an appetizer, garnished with parsley, " +
                "or sprinkled with parmesan cheese. It is served with dips: peppercorn mayonnaise, tzatziki, or in the United States, " +
                "marinara sauce, tartar sauce, or cocktail sauce. In Mexico it is served with Tabasco sauce or habanero.");
        foodItem.getNutritionTable().put("Calories", "100");
        foodItem.getNutritionTable().put("Carbohydrates", "9.75g");
        foodItem.getNutritionTable().put("Protein", "2g");
        foodItem.getNutritionTable().put("Fat", "2.93g");
        foodItem.getNutritionTable().put("Fiber", "0.3g");
        homeCook.getFoodItems().add(foodItem);

        //#5
        foodItem = new FoodItem("Chicken Sizzler", "sizzlerm1");
        foodItem.setDescription("Stir-fried shredded chicken with mixed vegetables in a blend of special sauces");
        foodItem.setPrice(15.99);
        foodItem.setServing("2-4");
        foodItem.setReadyTime("35");
        foodItem.setLongDescription("Sizzler is a open-roasted, grilled or shallow fried piece of meat, chicken, " +
                "fish or vegetable patty, served with french fries, shredded cabbage, tomatoes, carrots, french beans etc., " +
                "served on a metal or stone hot plate, kept on a wooden base. The word \"sizzler\" comes from the sizzle that " +
                "one hears when, after heating the dish under a grill (the meat is usually cooked separately to conserve time), " +
                "the Worcestershire Sauce based gravy is poured on, which dribbles on the hot plate and heats up. This would keep " +
                "the meat and vegetables hot for a longer time than the traditional method of serving on a china plate.");
        foodItem.getNutritionTable().put("Calories", "533");
        foodItem.getNutritionTable().put("Carbohydrates", "59g");
        foodItem.getNutritionTable().put("Protein", "28g");
        foodItem.getNutritionTable().put("Fat", "20g");
        foodItem.getNutritionTable().put("Fiber", "0.2g");
        homeCook.getFoodItems().add(foodItem);

        //#6
        foodItem = new FoodItem("Szechwan fried rice", "ricem1");
        foodItem.setDescription("Long grain rice tossed with spicy Szechwan sauce");
        foodItem.setPrice(9.49);
        foodItem.setServing("1-2");
        foodItem.setReadyTime("25");
        foodItem.setLongDescription("Fried rice, chao fan (Chinese), is a dish of steamed rice stir-fried in a wok, " +
                "often mixed with other ingredients, such as eggs, vegetables, and meat, and as such, often served as a " +
                "complete dish.Many popular varieties of fried rice have their own specific list of ingredients.  Onions, " +
                "scallion and  garlic are often added for extra flavor. It is popularly eaten either as an accompaniment to " +
                "another dish, or as a course by itself.Schezwan sauce is added to that.");
        foodItem.getNutritionTable().put("Calories", "162");
        foodItem.getNutritionTable().put("Carbohydrates", "54g");
        foodItem.getNutritionTable().put("Protein", "11g");
        foodItem.getNutritionTable().put("Fat", "5g");
        foodItem.getNutritionTable().put("Fiber", "4g");
        homeCook.getFoodItems().add(foodItem);

        //#7
        foodItem = new FoodItem("Hakka noodles", "hakkam1");
        foodItem.setDescription("Soft fried noodles with shredded vegetables and beans sprout");
        foodItem.setPrice(8.99);
        foodItem.setServing("1-2");
        foodItem.setReadyTime("25");
        foodItem.setLongDescription("Hakka Noodles is another Indo-Chinese recipe which is a favorite among kids and adults. " +
                "In this the boiled noodles are stir fried with vegetables and sauces. Meal include chicken, shrimp or vegetable " +
                "variants of Hakka or Sichuan noodle.");
        foodItem.getNutritionTable().put("Calories", "370");
        foodItem.getNutritionTable().put("Carbohydrates", "6.8g");
        foodItem.getNutritionTable().put("Protein", "9.8g");
        foodItem.getNutritionTable().put("Fat", "13g");
        foodItem.getNutritionTable().put("Fiber", "1.2g");
        homeCook.getFoodItems().add(foodItem);

        //#8
        foodItem = new FoodItem("Lo-Mein", "meinm1");
        foodItem.setDescription("Savory soy sauce tossed with stir-fried noodles, julienned carrots, mushrooms and cabbage");
        foodItem.setPrice(8.49);
        foodItem.setServing("3-4");
        foodItem.setReadyTime("45");
        foodItem.setLongDescription("The dish is popular throughout the Chinese diaspora and appears on the menus of " +
                "Chinese restaurants. It is a stir-fried dish consisting of noodles, meat (chicken being most common but pork, " +
                "beef, shrimp or tofu sometimes being substituted), onions and celery. It is often served as a specific dish at " +
                "westernized Chinese restaurants.");
        foodItem.getNutritionTable().put("Calories", "289");
        foodItem.getNutritionTable().put("Carbohydrates", "65g");
        foodItem.getNutritionTable().put("Protein", "13g");
        foodItem.getNutritionTable().put("Fat", "4g");
        foodItem.getNutritionTable().put("Fiber", "1.2g");
        homeCook.getFoodItems().add(foodItem);

        homeCooks.add(homeCook);
        //CHINESE ENDS


        //VIETNAMESE STARTS ************************************************************************************************
        homeCook = new HomeCook("Binh's Kitchen", "669-333-1215", "pho.jpg");
        homeCook.setCuisine("Vietnamese");
        homeCook.setLargeImage("binh_kitchen");
        homeCook.setAddress("3111 Mission College Blvd, Santa Clara, CA 95054");
        homeCook.setTime("10:00AM – 10:00PM");
        homeCook.setRating(3.5f);

        homeCook.getHsvList().add("banhh1");
        homeCook.getHsvList().add("banhh2");
        homeCook.getHsvList().add("chaoh1");
        homeCook.getHsvList().add("chaoh2");
        homeCook.getHsvList().add("comh1");
        homeCook.getHsvList().add("comhh1");

        //#1
        foodItem = new FoodItem("Banh Mi Bo Kho", "banh_mi");
        foodItem.setDescription("Beef Stew with Baguette");
        foodItem.setPrice(5.99);
        foodItem.setServing("2");
        foodItem.setReadyTime("25");
        foodItem.setLongDescription("A stew is a combination of solid food ingredients that have been " +
                "cooked in liquid and served in the resultant gravy. Ingredients in a stew can include any " +
                "combination of vegetables (such as carrots, potatoes, onions, beans, peppers and tomatoes), meat, " +
                "especially tougher meats suitable for slow-cooking, such as beef. Poultry, sausages, and seafood are also " +
                "used. While water can be used as the stew-cooking liquid, wine, stock, and beer are also common. Seasoning and " +
                "flavourings may also be added. Stews are typically cooked at a relatively low temperature (simmered, not boiled), " +
                "allowing flavors to mingle");
        foodItem.getNutritionTable().put("Calories", "425g");
        foodItem.getNutritionTable().put("Carbohydrates", "60g");
        foodItem.getNutritionTable().put("Protein", "45g");
        foodItem.getNutritionTable().put("Fat", "12g");
        foodItem.getNutritionTable().put("Fiber", "2.3g");
        homeCook.getFoodItems().add(foodItem);

        //#2
        foodItem = new FoodItem("Cháo Gà", "chao_ga");
        foodItem.setDescription("Congee is a soup and a comfort food. This recipe is flavorful, light, and goes down real " +
                "easy when you are feeling a little out of the weather");
        foodItem.setPrice(7.99);
        foodItem.setServing("1-2");
        foodItem.setReadyTime("20");
        foodItem.setLongDescription("Congee is a type of rice porridge or gruel popular in many Asian countries. When " +
                "eaten as plain rice congee, it is most often served with side dishes. When additional ingredients, such as " +
                "meat, fish, and flavorings, are added while preparing the congee, it is most often served as a meal on its " +
                "own, especially for the ill. Names for congee are as varied as the style of its preparation. Despite its many " +
                "variations, it is usually a thick porridge of rice largely disintegrated after prolonged cooking in water");
        foodItem.getNutritionTable().put("Calories", "284g");
        foodItem.getNutritionTable().put("Carbohydrates", "54g");
        foodItem.getNutritionTable().put("Protein", "9g");
        foodItem.getNutritionTable().put("Fat", "4g");
        foodItem.getNutritionTable().put("Fiber", "1.1g");
        homeCook.getFoodItems().add(foodItem);

        //#3
        foodItem = new FoodItem("Mi Xao Don Rau Cai", "mi_rao");
        foodItem.setDescription("Crispy Noodles with Stir - fried Vegetables");
        foodItem.setPrice(10.99);
        foodItem.setServing("2-3");
        foodItem.setReadyTime("35");
        foodItem.setLongDescription("Vietnamese noodles are available in either fresh or dried form. Vietnamese " +
                "noodles are a popular choice. There are many variations, which include soups and dishes. Spicy beef and " +
                "noodles is a very popular combination for weddings");
        foodItem.getNutritionTable().put("Calories", "334g");
        foodItem.getNutritionTable().put("Carbohydrates", "55g");
        foodItem.getNutritionTable().put("Protein", "15g");
        foodItem.getNutritionTable().put("Fat", "6g");
        foodItem.getNutritionTable().put("Fiber", "1.2g");
        homeCook.getFoodItems().add(foodItem);

        //#4
        foodItem = new FoodItem("Com Suon", "com");
        foodItem.setDescription("It is composed of broken rice (com tam), suon (grilled pork chop), bi (pork skin), " +
                "cha trung hap (steamed pork-egg custard) topped by scallion oil");
        foodItem.setPrice(8.99);
        foodItem.setServing("3-4");
        foodItem.setReadyTime("45");
        foodItem.setLongDescription("Broken rice, is a Vietnamese dish made from rice with fractured rice grains. " +
                "Tam refers to the broken rice grains, while cơm refers to cooked rice. Also known as Cơm tấm Sài Gòn " +
                "(Saigon-style broken rice), particularly served in southern Vietnam, in Saigon. It is usually served with " +
                "grilled pork (either ribs or shredded) plus the Vietnamese dish bì (thinly shredded pork mixed with cooked and " +
                "thinly shredded pork skin) over broken rice. The rice and meat are served with various greens and pickled vegetables, " +
                "along with a prawn paste cake, trứng hấp (steamed egg), and grilled prawns. Typically, restaurants will serve " +
                "this popular combination rice plate with a small bowl of nước chấm, as well as a small bowl of soup broth (canh) " +
                "with garlic chives (to cleanse the throat). The dish cơm tấm bì comes with a chả trứng egg meatloaf.");
        foodItem.getNutritionTable().put("Calories", "300g");
        foodItem.getNutritionTable().put("Carbohydrates", "17g");
        foodItem.getNutritionTable().put("Protein", "7.3g");
        foodItem.getNutritionTable().put("Fat", "9.6g");
        foodItem.getNutritionTable().put("Fiber", "2.6g");
        homeCook.getFoodItems().add(foodItem);

        homeCooks.add(homeCook);
        //VIETNAMESE ENDS


        //JAPANESE STARTS  ************************************************************************************************
        homeCook = new HomeCook("Chiko's Kitchen", "660-365-0801", "ramen.jpg");
        homeCook.setCuisine("Japanese");
        homeCook.setLargeImage("japanesekitchen1");
        homeCook.setRating(5f);
        homeCook.setAddress("300 Santana Row, San Jose, CA 95128");
        homeCook.setTime("10:00AM – 1:00PM, 5:00PM - 10:00PM");

        homeCook.getHsvList().add("gingerporkh1");
        homeCook.getHsvList().add("honeysoyh1");
        homeCook.getHsvList().add("honeysoyh3");
        homeCook.getHsvList().add("sushih1");
        homeCook.getHsvList().add("honeysoyh2");
        homeCook.getHsvList().add("sushih2");

        //#1
        foodItem = new FoodItem("Baked Tonkatsu", "baked_tonkatsu");
        foodItem.setDescription("Tender and juicy pork loin wrapped in crispy golden panko crust, serve with tonkatsu " +
                "sauce and freshly ground sesame seeds");
        foodItem.setPrice(8.99);
        foodItem.setServing("1-2");
        foodItem.setReadyTime("25");
        foodItem.setLongDescription("Tonkatsu (pork cutlet), is a Japanese food which consists of a breaded, deep-fried " +
                "pork cutlet. There are two main types, fillet and loin. It is often served with shredded cabbage. Tonkatsu " +
                "originated in Japan in the 19th century. As well as being served as a single dish, it is also used as a sandwich " +
                "filling or in combination with curry.");
        foodItem.getNutritionTable().put("Calories", "94.6g");
        foodItem.getNutritionTable().put("Carbohydrates", "0.2g");
        foodItem.getNutritionTable().put("Protein", "11.6g");
        foodItem.getNutritionTable().put("Fat", "1.8g");
        foodItem.getNutritionTable().put("Fiber", "0.1g");
        homeCook.getFoodItems().add(foodItem);

        //#2
        foodItem = new FoodItem("Honey Soy Sauce Chicken", "honey_soy");
        foodItem.setDescription("Easy honey soy sauce chicken marinated in sake, soy sauce, and honey");
        foodItem.setPrice(7.99);
        foodItem.setServing("2-3");
        foodItem.setReadyTime("15");
        foodItem.setLongDescription("Japanese culture has adapted as chāshū. Unlike its Chinese " +
                "variant, it is prepared by rolling the meat into a log and then braising it at a low temperature. " +
                "The Japanese adaptation is typically seasoned with honey and soy sauce, without the red food colouring, " +
                "sugar, or five-spice powder");
        foodItem.getNutritionTable().put("Calories", "350g");
        foodItem.getNutritionTable().put("Carbohydrates", "17.8g");
        foodItem.getNutritionTable().put("Protein", "53.6g");
        foodItem.getNutritionTable().put("Fat", "6.1g");
        foodItem.getNutritionTable().put("Fiber", "2.1g");
        homeCook.getFoodItems().add(foodItem);

        //#3
        foodItem = new FoodItem("Ginger Pork (Shogayaki)", "ginger_pork");
        foodItem.setDescription("Tender juicy pork slices cooked in a sweet garlic ginger sauce, garnish with green onion");
        foodItem.setPrice(11.99);
        foodItem.setServing("3-4");
        foodItem.setReadyTime("45");
        foodItem.setLongDescription("Pork Shogayaki (豚の生姜焼き; buta no shogayaki) is a dish in Japanese cuisine. " +
                "Shoga (生姜) means ginger, and yaki (焼き) means grill or fry. It can also be made with beef, but the pork " +
                "version is so much more popular that the term \"shogayaki\" generally refers only to pork in Japan. " +
                "It is the second most popular Japanese pork dish after tonkatsu. Shogayaki is a common addition to bento boxes, " +
                "as it can be eaten cold. However, it is more commonly served hot with rice and shredded cabbage.");
        foodItem.getNutritionTable().put("Calories", "232g");
        foodItem.getNutritionTable().put("Carbohydrates", "4.1g");
        foodItem.getNutritionTable().put("Protein", "23.4g");
        foodItem.getNutritionTable().put("Fat", "12.5g");
        foodItem.getNutritionTable().put("Fiber", "1.9g");
        homeCook.getFoodItems().add(foodItem);

        //#4
        foodItem = new FoodItem("Chicken Katsu", "katsum1");
        foodItem.setDescription("Deep fried chicken cutlet");
        foodItem.setPrice(10.99);
        foodItem.setReadyTime("45");
        foodItem.setServing("3");
        foodItem.setLongDescription("Chicken katsu or tori katsu is a Japanese dish " +
                "which is also popular in Hawaii. It consists of a breaded, deep-fried chicken cutlet one to two " +
                "centimeters thick that is sliced into bite-sized pieces or strips");
        foodItem.getNutritionTable().put("Calories", "890g");
        foodItem.getNutritionTable().put("Carbohydrates", "30.2g");
        foodItem.getNutritionTable().put("Protein", "61g");
        foodItem.getNutritionTable().put("Fat", "48g");
        foodItem.getNutritionTable().put("Fiber", "10g");
        homeCook.getFoodItems().add(foodItem);

        //#5
        foodItem = new FoodItem("Sushi", "sushim1");
        foodItem.setDescription("Tuna, Salmon and fluke sushi with tuna roll and cucmber roll");
        foodItem.setPrice(9.99);
        foodItem.setReadyTime("30");
        foodItem.setServing("1-2");
        foodItem.setLongDescription("Sushi is a food preparation originating in Japan, consisting of cooked vinegared " +
                "rice combined with other ingredients such as raw uncooked seafood, vegetables and sometimes tropical fruits.");
        foodItem.getNutritionTable().put("Calories", "140g");
        foodItem.getNutritionTable().put("Carbohydrates", "28g");
        foodItem.getNutritionTable().put("Protein", "2.1g");
        foodItem.getNutritionTable().put("Fat", "5.7g");
        foodItem.getNutritionTable().put("Fiber", "5.8g");
        homeCook.getFoodItems().add(foodItem);

        homeCooks.add(homeCook);
        //JAPANESE ENDS

        //ETHIOPIAN STARTS ************************************************************************************************
        homeCook = new HomeCook("Berta's Kitchen", "408-327-9045", "meal.jpg");
        homeCook.setLargeImage("berta_kitchen");
        homeCook.setCuisine("Ethiopian");
        homeCook.setAddress("1320 Saratoga Ave, San Jose, CA 95129");
        homeCook.setTime("10:00AM – 2:00 PM, 5:00PM – 10:00PM");
        homeCook.setRating(4.0f);

        homeCook.getHsvList().add("doroh1");
        homeCook.getHsvList().add("ethh1");
        homeCook.getHsvList().add("gomenh1");
        homeCook.getHsvList().add("gomenh2");
        homeCook.getHsvList().add("missirh1");
        homeCook.getHsvList().add("sambussah1");
        homeCook.getHsvList().add("missirh2");
        homeCook.getHsvList().add("doroh2");

        //#1
        foodItem = new FoodItem("Doro Wot", "doro_wot");
        foodItem.setDescription("Chicken stew simmered in hot spices, herbs, seasoned in fenugreek, cooked until tender");
        foodItem.setPrice(10.99);
        foodItem.setLongDescription("Wat is traditionally eaten with injera, a spongy flat bread made from the millet-like " +
                "grain known as teff. Doro wat is one such stew, made from chicken and sometimes hard-boiled eggs; the ethnologist " +
                "Donald Levine records that doro wat is the most popular traditional food in Ethiopia, often eaten as part of a " +
                "group who share a communal bowl and basket of injera.");
        foodItem.getNutritionTable().put("Calories", "381g");
        foodItem.getNutritionTable().put("Carbohydrates", "6.5g");
        foodItem.getNutritionTable().put("Protein", "43.6g");
        foodItem.getNutritionTable().put("Fat", "19.2g");
        foodItem.getNutritionTable().put("Fiber", "1.3g");
        foodItem.setServing("2-3");
        foodItem.setReadyTime("40");
        homeCook.getFoodItems().add(foodItem);


        //#2
        foodItem = new FoodItem("Doro Tibbs", "doro_tibs");
        foodItem.setDescription("Tender chicken breast cut in cubes sauted with onions, green chilies, seasoned butter and herbs");
        foodItem.setPrice(9.99);
        foodItem.setLongDescription("Meat along with vegetables are sautéed to make tibs. Tibs is served in a variety of " +
                "manners, and can range from hot to mild or contain little to no vegetables. There are many variations of the " +
                "delicacy, depending on type, size or shape of the cuts of meat used. Doro tibs is a sauteed chicken dish, as " +
                "opposed to doro wat, which is a chicken stew. The main ingredient of this dish is mitmita, an Ethiopian chili powder");
        foodItem.getNutritionTable().put("Calories", "257g");
        foodItem.getNutritionTable().put("Carbohydrates", "3.7g");
        foodItem.getNutritionTable().put("Protein", "44.1g");
        foodItem.getNutritionTable().put("Fat", "4.6g");
        foodItem.getNutritionTable().put("Fiber", "2.1g");
        foodItem.setServing("1-2");
        foodItem.setReadyTime("25");
        homeCook.getFoodItems().add(foodItem);

        //#3
        foodItem = new FoodItem("Zilzil Tibbs", "zilzil_tibs");
        foodItem.setDescription("Strips of tender beef sauted in onions and jalapenos, seasoned with garlic and black pepper");
        foodItem.setPrice(10.99);
        foodItem.setLongDescription("Tibs comes in several styles, most commonly chikina tib, fried in a sauce with berbere spice, onions, bell peppers, and tomato; and zil-zil tibs, a more deep fried breaded version served with tangy sauces");
        foodItem.getNutritionTable().put("Calories", "232g");
        foodItem.getNutritionTable().put("Carbohydrates", "4.1g");
        foodItem.getNutritionTable().put("Protein", "23.4g");
        foodItem.getNutritionTable().put("Fat", "12.5g");
        foodItem.getNutritionTable().put("Fiber", "1.9g");
        foodItem.setServing("2-3");
        foodItem.setReadyTime("18");
        homeCook.getFoodItems().add(foodItem);


        //#4
        foodItem = new FoodItem("Yebeg Tibbs", "yebeg_tibs");
        foodItem.setDescription("Cubes of selected lamb meat sauted in spiced onions, jalapenos and herbed butter");
        foodItem.setPrice(10.99);
        foodItem.setLongDescription("Tibs is served in a variety of manners, and can range from hot to mild or contain " +
                "little to no vegetables. There are many variations of the delicacy, depending on type, size or shape of the " +
                "cuts of meat used. Yebeg is lamb");
        foodItem.getNutritionTable().put("Calories", "378g");
        foodItem.getNutritionTable().put("Carbohydrates", "4.8g");
        foodItem.getNutritionTable().put("Protein", "7.3g");
        foodItem.getNutritionTable().put("Fat", "3.6g");
        foodItem.getNutritionTable().put("Fiber", "0.6g");
        foodItem.setServing("1");
        foodItem.setReadyTime("15");
        homeCook.getFoodItems().add(foodItem);

        //#5
        foodItem = new FoodItem("Yemisser Wot", "yemesir_wot");
        foodItem.setDescription("Split red lentils simmered in berbere sauce");
        foodItem.setPrice(9.99);
        foodItem.setLongDescription("Wat is traditionally eaten with injera, a spongy flat bread made from the millet-like " +
                "grain known as teff. Doro wat is one such stew, made from chicken and sometimes hard-boiled eggs; the ethnologist " +
                "Donald Levine records that doro wat is the most popular traditional food in Ethiopia, often eaten as part of a group " +
                "who share a communal bowl and basket of injera. Yemisser is split lentils");
        foodItem.getNutritionTable().put("Calories", "400g");
        foodItem.getNutritionTable().put("Carbohydrates", "36g");
        foodItem.getNutritionTable().put("Protein", "16g");
        foodItem.getNutritionTable().put("Fat", "10g");
        foodItem.getNutritionTable().put("Fiber", "0.7g");
        foodItem.setServing("4-5");
        foodItem.setReadyTime("60");
        homeCook.getFoodItems().add(foodItem);

        //#6
        foodItem = new FoodItem("Gomen Wot", "gomen_wot");
        foodItem.setDescription("Chopped collard greens simmered in a mild sauce");
        foodItem.setPrice(8.99);
        foodItem.setLongDescription("Wat begins with a large amount of chopped red onion, which is simmered or sauteed in a pot. " +
                "Once the onions have softened, niter kebbeh (or, in the case of vegan dishes, vegetable oil) is added. Following " +
                "this, berbere is added to make a spicy keiy wat. Gomen is greens chopped and added to the wot");
        foodItem.getNutritionTable().put("Calories", "127g");
        foodItem.getNutritionTable().put("Carbohydrates", "9.9g");
        foodItem.getNutritionTable().put("Protein", "2.8g");
        foodItem.getNutritionTable().put("Fat", "9.6g");
        foodItem.getNutritionTable().put("Fiber", "2.9g");
        foodItem.setServing("1-3");
        foodItem.setReadyTime("40");
        homeCook.getFoodItems().add(foodItem);

        //#7
        foodItem = new FoodItem("Sambussa", "sambussa");
        foodItem.setDescription("Thin dough shells stuffed with lentils, onion, hot green & herbs. This meatless dish is lightly deep fried in vegetable oil to a golden perfection");
        foodItem.setPrice(5.99);
        foodItem.setLongDescription("A samosa or samoosa is a fried or baked pastry with a savoury filling, " +
                "such as spiced potatoes, onions, peas, lentils, macaroni, noodles, and/or minced meat (lamb, beef or chicken)." +
                "Pine nuts can also be added. The samosa is claimed to have originated in Tanzania. Its size and consistency may vary," +
                " but typically it is distinctly triangular or tetrahedral in shape");
        foodItem.getNutritionTable().put("Calories", "186g");
        foodItem.getNutritionTable().put("Carbohydrates", "15g");
        foodItem.getNutritionTable().put("Protein", "10g");
        foodItem.getNutritionTable().put("Fat", "10g");
        foodItem.getNutritionTable().put("Fiber", "0.5g");
        foodItem.setServing("3");
        foodItem.setReadyTime("30");
        homeCook.getFoodItems().add(foodItem);

        //#8
        foodItem = new FoodItem("Ethiopian Pastries", "ethiopian_pastries");
        foodItem.setDescription("cake-ish pastries that are not too sweet and range from doughy to dense. Dairy and meat free");
        foodItem.setPrice(5.99);
        foodItem.setLongDescription("Dessert is not a mainstay of Ethiopian cooking, though many Italian dishes like tiramisu and " +
                "chocolate mousse have become incorporated into the cuisine. Instead, Ethiopians make cake-ish pastries that are " +
                "not too sweet and range from doughy to dense. They are often fasting-approved, or dairy and meat free");
        foodItem.getNutritionTable().put("Calories", "146g");
        foodItem.getNutritionTable().put("Carbohydrates", "15.1g");
        foodItem.getNutritionTable().put("Protein", "1.7g");
        foodItem.getNutritionTable().put("Fat", "9g");
        foodItem.getNutritionTable().put("Fiber", "0.6g");
        foodItem.setServing("4-5");
        foodItem.setReadyTime("90");
        homeCook.getFoodItems().add(foodItem);

        homeCooks.add(homeCook);
        //ETHIPIAN ENDS

        //GREEK STARTS ************************************************************************************************
        homeCook = new HomeCook("Vaino's Kitchen", "(408)-732-1259", "greek.jpg");
        homeCook.setCuisine("Greek");
        homeCook.setLargeImage("greekkitchen");
        homeCook.setAddress("450 Serra Mall, Stanford, CA 94305");
        homeCook.setTime("10:00AM – 2:00 PM, 5:00PM – 10:00PM");
        homeCook.setRating(3.0f);

        homeCook.getHsvList().add("avgolemonoh1");
        homeCook.getHsvList().add("gh1");
        homeCook.getHsvList().add("gh2");
        homeCook.getHsvList().add("gh3");
        homeCook.getHsvList().add("gyroh1");
        homeCook.getHsvList().add("greeksh1");
        homeCook.getHsvList().add("gh5");
        homeCook.getHsvList().add("greeksh2");
        homeCook.getHsvList().add("gh4");
        homeCook.getHsvList().add("avgolemonoh2");

        //#1
        foodItem = new FoodItem("Greek Salad", "greeksm1");
        foodItem.setDescription("Greek salad, or horiatiki salata, is a rough country salad of juicy tomatoes, " +
                "crisp cucumber, plump kalamata olives. ");
        foodItem.setReadyTime("30");
        foodItem.setServing("2-3");
        foodItem.setPrice(11.99);
        foodItem.setLongDescription("Greek salad consists of tomatoes, sliced cucumbers, onion, feta cheese, and " +
                "olives (usually Kalamata olives), typically seasoned with salt and oregano, and dressed with olive oil. " +
                "Sliced capsicum, usually green, is often added also.");
        foodItem.getNutritionTable().put("Calories", "437");
        foodItem.getNutritionTable().put("Carbohydrates", "65g");
        foodItem.getNutritionTable().put("Protein", "5g");
        foodItem.getNutritionTable().put("Fat", "1g");
        foodItem.getNutritionTable().put("Fiber", "6g");
        homeCook.getFoodItems().add(foodItem);

        //#2
        foodItem = new FoodItem("Dakos", "dakosm1");
        foodItem.setDescription("Dry barley rusk, soaked in olive oil and topped with diced tomatoes, herbs, and feta cheese. Capers are often added also");
        foodItem.setReadyTime("20");
        foodItem.setServing("1");
        foodItem.setPrice(5.50);
        foodItem.setLongDescription("Dakos or ntakos ,also known as koukouvagia or koukouvayia (κουκουβάγια, owl) or—" +
                "in eastern Crete—kouloukopsomo is a Cretan meze consisting of a slice of soaked dried bread or barley rusk " +
                "topped with chopped tomatoes and crumbled feta or mizithra cheese, and flavored with herbs such as dried oregano. " +
                "Olives and pepper can also be added.");
        foodItem.getNutritionTable().put("Calories", "435");
        foodItem.getNutritionTable().put("Carbohydrates", "46g");
        foodItem.getNutritionTable().put("Protein", "17g");
        foodItem.getNutritionTable().put("Fat", "22g");
        foodItem.getNutritionTable().put("Fiber", "6g");
        homeCook.getFoodItems().add(foodItem);

        //#3
        foodItem = new FoodItem("Fried Squid", "squidm1");
        foodItem.setDescription("Batter-coated, deep fried squid, served plain, with salt and lemon on the side.");
        foodItem.setPrice(8.30);
        foodItem.setReadyTime("45");
        foodItem.setServing("3-4");
        foodItem.setLongDescription("Squid is a popular food in many parts of the world. Calamari is a culinary name for " +
                "squid, especially for dishes from the Mediterranean, notably fried squid (fried calamari).Fried squid appears in " +
                "Mediterranean cuisine.Squid can be prepared for consumption in other ways. ");
        foodItem.getNutritionTable().put("Calories", "134");
        foodItem.getNutritionTable().put("Carbohydrates", "1.4g");
        foodItem.getNutritionTable().put("Protein", "28g");
        foodItem.getNutritionTable().put("Fat", "1.2g");
        foodItem.getNutritionTable().put("Fiber", "1g");
        homeCook.getFoodItems().add(foodItem);

        //#4
        foodItem = new FoodItem("Loukaniko", "loukanikom1");
        foodItem.setDescription("Sausage made from pork and/or lamb. Typically flavoured with orange zest or leeks.");
        foodItem.setPrice(8.30);
        foodItem.setReadyTime("25");
        foodItem.setServing("1-2");
        foodItem.setLongDescription("Lukániko is the common Greek word for pork sausage, but in English it refers " +
                "specifically to Greek sausages flavored with orange peel, fennel seed, and various other dried herbs and seeds, " +
                "and sometimes smoked over aromatic woods. Greek sausages are also often flavoured with greens, especially leeks.");
        foodItem.getNutritionTable().put("Calories", "234");
        foodItem.getNutritionTable().put("Carbohydrates", "2.5g");
        foodItem.getNutritionTable().put("Protein", "81.5g");
        foodItem.getNutritionTable().put("Fat", "16.5g");
        foodItem.getNutritionTable().put("Fiber", "5g");
        homeCook.getFoodItems().add(foodItem);

        //#5
        foodItem = new FoodItem("Avgolemono", "avgolemonom1");
        foodItem.setDescription("'Egg-lemon' soup: chicken, meat, vegetable, or fish broth thickened with eggs, " +
                "lemon juice, and rice.");
        foodItem.setPrice(8.30);
        foodItem.setReadyTime("15");
        foodItem.setServing("1");
        foodItem.setLongDescription("Avgolemono or egg-lemon sauce, is a family of Mediterranean sauces and " +
                "soupsmade with egg yolk and lemon juice mixed with broth, heated until they thicken. In Arabic, it is called " +
                "tarbiya or beida bi-lemoune 'egg with lemon'; and in Turkish terbiye. In Sephardic Jewish cuisine, it is " +
                "called agristada or salsa blanco, and in Italian cuisine, bagna brusca, brodettato, or brodo brusco. " +
                "It is also widely used in Balkan cuisine.");
        foodItem.getNutritionTable().put("Calories", "242");
        foodItem.getNutritionTable().put("Carbohydrates", "33g");
        foodItem.getNutritionTable().put("Protein", "7g");
        foodItem.getNutritionTable().put("Fat", "10g");
        foodItem.getNutritionTable().put("Fiber", "6g");
        homeCook.getFoodItems().add(foodItem);

        //#6
        foodItem = new FoodItem("Gyros", "gyrosm1");
        foodItem.setDescription("'Meat roasted and sliced on a turning spit, typically served with sauces like " +
                "tzatziki and garnishes (tomato, onions) on pita bread (a popular fast food in Greece and Cyprus).");
        foodItem.setPrice(8.30);
        foodItem.setReadyTime("50");
        foodItem.setServing("3-4");
        foodItem.setLongDescription("A gyro or gyros is a Greek dish made of meat cooked on a " +
                "vertical rotisserie, normally pork, chicken, beef, veal, lamb or mutton, or other alternatives such as " +
                "feta or haloumi cheese, and usually served wrapped in a flatbread such as pita or sandwich, with fries, " +
                "tomato, onion, and tzatziki sauce or mayonnaise.");
        foodItem.getNutritionTable().put("Calories", "593");
        foodItem.getNutritionTable().put("Carbohydrates", "74.02g");
        foodItem.getNutritionTable().put("Protein", "44.12g");
        foodItem.getNutritionTable().put("Fat", "12.21g");
        foodItem.getNutritionTable().put("Fiber", "3.9g");
        homeCook.getFoodItems().add(foodItem);

        homeCooks.add(homeCook);
        //GREEK ENDS
    }
}
