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

        // #1
        HomeCook homeCook = new HomeCook("Maria's Kitchen", "12345678", "pasta.jpg");
        homeCook.setCuisine("Italian");
        homeCook.setRating(3.5f);
        homeCook.setLargeImage("main_kitchen1");

        FoodItem foodItem = new FoodItem("Pizza", "food1");
        foodItem.setDescription("With mozzarella, roasted red peppers and basil with alfredo and garlic spread");
        homeCook.getFoodItems().add(foodItem);

        foodItem = new FoodItem("Pasta", "food1");
        foodItem.setDescription("Ziti, Prosciutto, Asiago Cheese & Red Pepper Cream Sauce");
        homeCook.getFoodItems().add(foodItem);

        foodItem = new FoodItem("Lasagne", "food1");
        foodItem.setDescription("Layered Lasagna noodles, italian sausage and beef, ricotta cheese, tomato sauce, and baked mozzarella and romano cheese");
        homeCook.getFoodItems().add(foodItem);

        foodItem = new FoodItem("Tiramisu", "food1");
        foodItem.setDescription("Traditional Italian coffee cake - Lady fingers dipped in expresso layered with marscapone cream and topped with cocca powder");
        homeCook.getFoodItems().add(foodItem);

        foodItem = new FoodItem("Chicken Parmigiana", "food1");
        foodItem.setDescription("Mama's tomato sauce, lightly fried chicken breast, romano and mozzarella cheese baked until it's golden brown");
        homeCook.getFoodItems().add(foodItem);

        foodItem = new FoodItem("Macaroni & Cheese", "food1");
        foodItem.setDescription("Elbow macaroni and yellow cheese");
        homeCook.getFoodItems().add(foodItem);
        homeCooks.add(homeCook);

        // #2 Swathi's Kitchen -- -STARTS
        homeCook = new HomeCook("Swathi’s Kitchen", "408-984-9922", "paratha.jpg");
        homeCook.setLargeImage("swathi_kitchen");
        homeCook.setCuisine("Indian");
        homeCook.setAddress("500 El Camino Real, Santa Clara, CA 95050");
        homeCook.setTime("9:00 am to 10:00 pm");
        homeCook.setRating(4.5f);

        foodItem = new FoodItem("Saag Paneer", "saag_paneer");
        foodItem.setDescription("Spinach cooked with herbs, spices and traditional indian cheese");
        foodItem.setPrice(11.99);
        foodItem.setLongDescription("Saag paneer is a classic Indian dish of cooked spinach studded with cubes of fried paneer cheese. Thickened with cream or coconut milk, it's a hearty and filling vegetarian meal.");
        foodItem.getNutritionTable().put("Calories", "194");
        foodItem.getNutritionTable().put("Carbohydrates", "27.1g");
        foodItem.getNutritionTable().put("Protein", "14.6g");
        foodItem.getNutritionTable().put("Fat", "10g");
        foodItem.getNutritionTable().put("Fiber", "6.6g");
        foodItem.setServing("2-3");
        foodItem.setReadyTime("40");

        homeCook.getFoodItems().add(foodItem);


        foodItem = new FoodItem("Dosa", "dosa");
        foodItem.setDescription("stuffed with fillings of vegetables and served with sambar and chutney.");
        foodItem.setPrice(5.50);
        foodItem.setLongDescription("Dosa is a fermented crepe made from rice batter and black lentils.Sambar is a lentil-based vegetable stew or chowder based on a broth made with tamarind ");
        foodItem.getNutritionTable().put("Calories", "106");
        foodItem.getNutritionTable().put("Carbohydrates", "21.24g");
        foodItem.getNutritionTable().put("Protein", "2.15g");
        foodItem.getNutritionTable().put("Fat", "1.04g");
        foodItem.getNutritionTable().put("Fiber", "0.8g");
        foodItem.setServing("1");
        foodItem.setReadyTime("25");

        homeCook.getFoodItems().add(foodItem);


        foodItem = new FoodItem("Rice and Curry", "rice_and_curry");
        foodItem.setDescription("Larhe bowl of rice served with vegetable curry of your choice.");
        foodItem.setPrice(8.30);
        foodItem.setLongDescription("A large bowl of rice, most often boiled, but frequently fried. A vegetable curry, perhaps of green beans, jackfruit or leeks. ");
        foodItem.getNutritionTable().put("Calories", "403");
        foodItem.getNutritionTable().put("Carbohydrates", "55.5g");
        foodItem.getNutritionTable().put("Protein", "4.3g");
        foodItem.getNutritionTable().put("Fat", "9.1g");
        foodItem.getNutritionTable().put("Fiber", "6.7g");
        foodItem.setServing("3");
        foodItem.setReadyTime("45");

        homeCook.getFoodItems().add(foodItem);




        foodItem = new FoodItem("Daal", "daal");
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

        foodItem = new FoodItem("Chicken Tikka Masala", "chickentikka_masala");
        foodItem.setDescription("Breast meat barbecued in tandoor oven, then cooked with bell pepper, onion, garlic, ginger, tomatoes, cream, and spices.");
        foodItem.setPrice(10.50);
        foodItem.setLongDescription("Chicken tikka masala is chicken tikka, chunks of chicken marinated in spices and yogurt, that is then baked in a tandoor oven, and served in a masala (spice mix) sauce. The sauce usually includes tomatoes (frequently as purée), cream, coconut cream and various spices. The sauce or chicken pieces (or both) are coloured orange using foodstuffs such as turmeric powder, paprika powder or tomato puree.");
        foodItem.getNutritionTable().put("Calories", "849");
        foodItem.getNutritionTable().put("Carbohydrates", "105 g");
        foodItem.getNutritionTable().put("Protein", "29g");
        foodItem.getNutritionTable().put("Fat", "35g");
        foodItem.getNutritionTable().put("Fiber", "7g");
        foodItem.setServing("2-3");
        foodItem.setReadyTime("30");

        homeCook.getFoodItems().add(foodItem);


        foodItem = new FoodItem("Chicken Biryani", "chicken_biryani");
        foodItem.setDescription("Fragrant long-grained rice is layered with meat that have been cooked in a mixture of spices.");
        foodItem.setPrice(13.25);
        foodItem.setLongDescription("The  biryani is light, less spicy and is easy to digest. Mutton is the most common meat used, although beef, chicken, fish and prawns are also sometimes used. The basmati rice is cooked separately and flavoured with ghee and spices like star anise, cinnamon, cardamon and cloves.");
        foodItem.getNutritionTable().put("Calories", "548");
        foodItem.getNutritionTable().put("Carbohydrates", "48g");
        foodItem.getNutritionTable().put("Protein", "19g");
        foodItem.getNutritionTable().put("Fat", "25g");
        foodItem.getNutritionTable().put("Fiber", "3g");
        foodItem.setServing("3-4");
        foodItem.setReadyTime("90");

        homeCook.getFoodItems().add(foodItem);

        homeCooks.add(homeCook);
        // #2 Swathi's Kitchen -- -ENDS

        // #3
        homeCook = new HomeCook("Albert's kitchen", "57777788392", "food12.jpg");
        homeCook.setCuisine("American");
        homeCook.setLargeImage("albert_kitchen");
        homeCook.getFoodItems().add(new FoodItem("Burger", "pasta"));
        homeCook.getFoodItems().add(new FoodItem("Pizza", "pasta"));
        homeCooks.add(homeCook);
        homeCook.setRating(4.0f);

        // #4
        homeCook = new HomeCook("Liliana's kitchen", "57777788392", "tacos.jpg");
        homeCook.setCuisine("Mexican");
        homeCook.setLargeImage("liliana_kitchen");
        homeCook.getFoodItems().add(new FoodItem("Burrito", "pasta"));
        homeCook.getFoodItems().add(new FoodItem("Tacos", "pasta"));
        homeCooks.add(homeCook);

        // #5 WANGS KITCHEN ------ STARTS

        //Home cook object
        homeCook = new HomeCook("Wang's Kitchen", "408-433-9626", "food1.jpg");
        homeCook.setLargeImage("wangs_kitchen");
        homeCook.setCuisine("Chinese");
        homeCook.setAddress("500 El Camino Real, Santa Clara, CA 95050");
        homeCook.setTime("11:30 am to 10:00 pm");
        homeCook.setRating(3.0f);

        // Food Item1
        foodItem = new FoodItem("Manchow soup", "manchow_soup");
        foodItem.setDescription("Moderately Spiced chicken and vegetable broth topped with crispy noodles");
        foodItem.setPrice(9.99);
        foodItem.setLongDescription("Manchow soup is a soup popular in Indian Chinese cuisine due to its ease of preparation and hot spicy taste. It is available in large restaurants and street food carts alike. Although the soup is named after Manchuria it does not resemble any that is normally found in the cuisines of the region. It is a dark brown soup prepared with various vegetables, scallions, and chicken (in the non-vegetarian version only), thickened with stock and corn flour, and flavored with relatively generous doses of soy sauce, salt, garlic and chili peppers. It may also be garnished with chopped spring onions, and served with crispy dry noodles.");
        foodItem.getNutritionTable().put("Calories", "115");
        foodItem.getNutritionTable().put("Carbohydrates", "6.8g");
        foodItem.getNutritionTable().put("Protein", "9.8g");
        foodItem.getNutritionTable().put("Fat", "5.5g");
        foodItem.getNutritionTable().put("Fiber", "1.2g");
        foodItem.setServing("2");
        foodItem.setReadyTime("40");

        homeCook.getFoodItems().add(foodItem);

        // Food Item2
        foodItem = new FoodItem("Chicken Wonton Soup", "wonton_soup");
        foodItem.setDescription("Home Made Chicken wontons in a delicate clear soup");
        foodItem.setPrice(9.99);
        foodItem.setLongDescription("Wonton filling is essentially stir-fry, but with smaller particles and less cooking. It goes hot into a wonton wrapper (equal to 1/4 of an egg roll wrapper), which is then cooked in a hot broth. Note that these wontons do not contain cabbage and carrots, which are used by commercial wonton producers to cheapen the filling. The filling in these wontons is superior.Made as a water-based soup, this soup combines meat and pasta in a soothing chicken broth. Chicken Wonton Soup, or Chicken Won Ton as it may also be referred, is a soup that contains cooked chicken meat, thick dumpling-like pasta, celery, spinach or herbs, and flavorings that are added to a chicken stock. This soup goes well with lunch, dinner or Asian inspired meals, events and celebrations.");
        foodItem.getNutritionTable().put("Calories", "181");
        foodItem.getNutritionTable().put("Carbohydrates", "7.08g");
        foodItem.getNutritionTable().put("Protein", "15g");
        foodItem.getNutritionTable().put("Fat", "14.24g");
        foodItem.getNutritionTable().put("Fiber", "1g");
        foodItem.setServing("1-2");
        foodItem.setReadyTime("26");

        homeCook.getFoodItems().add(foodItem);

        // Food Item3
        foodItem = new FoodItem("Chicken spring roll", "spring_roll");
        foodItem.setDescription("Spring rolls stuffed with julienne of vegetables, chicken and fried");
        foodItem.setPrice(5.99);
        foodItem.setLongDescription("Spring rolls are a large variety of filled, rolled appetizers or dim sum found in East Asian and Southeast Asian cuisine. The name is a literal translation of the Chinese chūn juǎn (春卷 'spring roll'). The kind of wrapper, fillings, and cooking technique used, as well as the name, vary considerably within this large area, depending on the region's culture.n Chinese cuisine, spring rolls are savoury rolls with cabbage and other vegetable fillings inside a wrapped cylinder shaped thin pastry. From areas such as Zhejiang in eastern China, and northern China. They are usually eaten during the Spring Festival in mainland China, hence the name. Meat varieties, particularly pork are also popular. Fried spring rolls are generally small and crisp. They can be sweet or savory; the latter are typically prepared with vegetables. This version is fully wrapped before being pan-fried or deep-fried.");
        foodItem.getNutritionTable().put("Calories", "65");
        foodItem.getNutritionTable().put("Carbohydrates", "7.12g");
        foodItem.getNutritionTable().put("Protein", "3.03g");
        foodItem.getNutritionTable().put("Fat", "2.61g");
        foodItem.getNutritionTable().put("Fiber", "0.5g");
        foodItem.setServing("2-3");
        foodItem.setReadyTime("50");

        homeCook.getFoodItems().add(foodItem);

        // Food Item4
        foodItem = new FoodItem("Golden fried calamari", "calamari");
        foodItem.setDescription("Batter fried calamari strips");
        foodItem.setPrice(10.99);
        foodItem.setLongDescription("Squid is a popular food in many parts of the world. Calamari is a culinary name for squid, especially for dishes from the Mediterranean, notably fried squid (fried calamari).[1] There are many ways of preparing and cooking squid, with every country and region having its own recipes.Fried squid (fried calamari, calamari) is a dish in Mediterranean cuisine. It consists of batter-coated, deep fried squid, fried for less than two minutes to prevent toughness. It is served plain, with salt and lemon on the side.In North America, it is a staple in seafood restaurants. It is served as an appetizer, garnished with parsley, or sprinkled with parmesan cheese. It is served with dips: peppercorn mayonnaise, tzatziki, or in the United States, marinara sauce, tartar sauce, or cocktail sauce. In Mexico it is served with Tabasco sauce or habanero.");
        foodItem.getNutritionTable().put("Calories", "100");
        foodItem.getNutritionTable().put("Carbohydrates", "9.75g");
        foodItem.getNutritionTable().put("Protein", "2g");
        foodItem.getNutritionTable().put("Fat", "2.93g");
        foodItem.getNutritionTable().put("Fiber", "0.3g");
        foodItem.setServing("2-3");
        foodItem.setReadyTime("40");

        homeCook.getFoodItems().add(foodItem);

        // Food Item5
        foodItem = new FoodItem("Chicken Sizzler", "sizzler");
        foodItem.setDescription("Stir-fried shredded chicken with mixed vegetables in a blend of special sauces");
        foodItem.setPrice(15.99);
        foodItem.setLongDescription("Sizzler is a open-roasted, grilled or shallow fried piece of meat, chicken, fish or vegetable patty, served with french fries, shredded cabbage, tomatoes, carrots, french beans etc., served on a metal or stone hot plate, kept on a wooden base. The word \"sizzler\" comes from the sizzle that one hears when, after heating the dish under a grill (the meat is usually cooked separately to conserve time), the Worcestershire Sauce based gravy is poured on, which dribbles on the hot plate and heats up. This would keep the meat and vegetables hot for a longer time than the traditional method of serving on a china plate.");
        foodItem.getNutritionTable().put("Calories", "533");
        foodItem.getNutritionTable().put("Carbohydrates", "59g");
        foodItem.getNutritionTable().put("Protein", "28g");
        foodItem.getNutritionTable().put("Fat", "20g");
        foodItem.getNutritionTable().put("Fiber", "0.2g");
        foodItem.setServing("2");
        foodItem.setReadyTime("45");

        homeCook.getFoodItems().add(foodItem);

        // Food Item6
        foodItem = new FoodItem("Szechwan fried rice", "sfried_rice");
        foodItem.setDescription("Long grain rice tossed with spicy Szechwan sauce");
        foodItem.setPrice(9.49);
        foodItem.setLongDescription("Fried rice, chao fan (Chinese), is a dish of steamed rice stir-fried in a wok, often mixed with other ingredients, such as eggs, vegetables, and meat, and as such, often served as a complete dish.Many popular varieties of fried rice have their own specific list of ingredients.  Onions, scallion and  garlic are often added for extra flavor. It is popularly eaten either as an accompaniment to another dish, or as a course by itself.Schezwan sauce is added to that.");
        foodItem.getNutritionTable().put("Calories", "162");
        foodItem.getNutritionTable().put("Carbohydrates", "54g");
        foodItem.getNutritionTable().put("Protein", "11g");
        foodItem.getNutritionTable().put("Fat", "5g");
        foodItem.getNutritionTable().put("Fiber", "4g");
        foodItem.setServing("2-3");
        foodItem.setReadyTime("30");

        homeCook.getFoodItems().add(foodItem);

        // Food Item7
        foodItem = new FoodItem("Hakka noodles", "hakka_noodles");
        foodItem.setDescription("Soft fried noodles with shredded vegetables and beans sprout");
        foodItem.setPrice(8.99);
        foodItem.setLongDescription("Hakka Noodles is another Indo-Chinese recipe which is a favorite among kids and adults. In this the boiled noodles are stir fried with vegetables and sauces. Meal include chicken, shrimp or vegetable variants of Hakka or Sichuan noodle.");
        foodItem.getNutritionTable().put("Calories", "370");
        foodItem.getNutritionTable().put("Carbohydrates", "6.8g");
        foodItem.getNutritionTable().put("Protein", "9.8g");
        foodItem.getNutritionTable().put("Fat", "13g");
        foodItem.getNutritionTable().put("Fiber", "1.2g");
        foodItem.setServing("2");
        foodItem.setReadyTime("25");

        homeCook.getFoodItems().add(foodItem);

        // Food Item8
        foodItem = new FoodItem("Lo-Mein", "chowmein");
        foodItem.setDescription("Savory soy sauce tossed with stir-fried noodles, julienned carrots, mushrooms and cabbage");
        foodItem.setPrice(8.49);
        foodItem.setDescription("The dish is popular throughout the Chinese diaspora and appears on the menus of Chinese restaurants. It is a stir-fried dish consisting of noodles, meat (chicken being most common but pork, beef, shrimp or tofu sometimes being substituted), onions and celery. It is often served as a specific dish at westernized Chinese restaurants.");
        foodItem.getNutritionTable().put("Calories", "289");
        foodItem.getNutritionTable().put("Carbohydrates", "65g");
        foodItem.getNutritionTable().put("Protein", "13g");
        foodItem.getNutritionTable().put("Fat", "4g");
        foodItem.getNutritionTable().put("Fiber", "1.2g");
        foodItem.setServing("2-3");
        foodItem.setReadyTime("40");

        homeCook.getFoodItems().add(foodItem);

        // add homecook to homecook list
        homeCooks.add(homeCook);

        // #5 WANGS KITCHEN ------ ENDS


        // #6
        homeCook = new HomeCook("Binh's Kitchen", "12345678", "pho.jpg");
        homeCook.setCuisine("Vietnamese");
        homeCook.setLargeImage("binh_kitchen");
        homeCook.getFoodItems().add(new FoodItem("Paratha", "food1"));
        homeCook.getFoodItems().add(new FoodItem("Pasta", "pasta"));
        homeCooks.add(homeCook);
        homeCook.setRating(3.5f);

        // #7
        homeCook = new HomeCook("Chiko's Kitchen", "12345678", "ramen.jpg");
        homeCook.setCuisine("Japanese");
        homeCook.setLargeImage("chicko_kitchen");
        homeCook.getFoodItems().add(new FoodItem("Paratha", "food1"));
        homeCook.getFoodItems().add(new FoodItem("Pasta", "pasta"));
        homeCooks.add(homeCook);
        homeCook.setRating(4.5f);

        // #8 Berta's Kitchen  ------ STARTS
        homeCook = new HomeCook("Berta's Kitchen", "408-327-9045", "meal.jpg");
        homeCook.setLargeImage("berta_kitchen");
        homeCook.setCuisine("Ethiopian");
        homeCook.setAddress("1320 Saratoga Ave, San Jose, CA 95129");
        homeCook.setTime("10:00AM – 2:00 PM, 5:00PM – 10:00PM");
        homeCook.setRating(4.0f);

//1st
        foodItem = new FoodItem("Doro Wot", "doro_wot");
        foodItem.setDescription("Chicken stew simmered in hot spices, herbs, seasoned in fenugreek, cooked until tender");
        foodItem.setPrice(10.99);
        foodItem.setLongDescription("Wat is traditionally eaten with injera, a spongy flat bread made from the millet-like grain known as teff. Doro wat is one such stew, made from chicken and sometimes hard-boiled eggs; the ethnologist Donald Levine records that doro wat is the most popular traditional food in Ethiopia, often eaten as part of a group who share a communal bowl and basket of injera.");
        foodItem.getNutritionTable().put("Calories", "381g");
        foodItem.getNutritionTable().put("Carbohydrates", "6.5g");
        foodItem.getNutritionTable().put("Protein", "43.6g");
        foodItem.getNutritionTable().put("Fat", "19.2g");
        foodItem.getNutritionTable().put("Fiber", "1.3g");
        homeCook.getFoodItems().add(foodItem);
        foodItem.setServing("2-3");
        foodItem.setReadyTime("40");

//2nd
        foodItem = new FoodItem("Doro Tibbs", "doro_tibs");
        foodItem.setDescription("Tender chicken breast cut in cubes sauted with onions, green chilies, seasoned butter and herbs");
        foodItem.setPrice(9.99);
        foodItem.setLongDescription("Meat along with vegetables are sautéed to make tibs. Tibs is served in a variety of manners, and can range from hot to mild or contain little to no vegetables. There are many variations of the delicacy, depending on type, size or shape of the cuts of meat used. Doro tibs is a sauteed chicken dish, as opposed to doro wat, which is a chicken stew. The main ingredient of this dish is mitmita, an Ethiopian chili powder");
        foodItem.getNutritionTable().put("Calories", "257g");
        foodItem.getNutritionTable().put("Carbohydrates", "3.7g");
        foodItem.getNutritionTable().put("Protein", "44.1g");
        foodItem.getNutritionTable().put("Fat", "4.6g");
        foodItem.getNutritionTable().put("Fiber", "2.1g");
        foodItem.setServing("1-2");
        foodItem.setReadyTime("25");

        homeCook.getFoodItems().add(foodItem);

//3rd
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


//4th
        foodItem = new FoodItem("Yebeg Tibbs", "yebeg_tibs");
        foodItem.setDescription("Cubes of selected lamb meat sauted in spiced onions, jalapenos and herbed butter");
        foodItem.setPrice(10.99);
        foodItem.setLongDescription("Tibs is served in a variety of manners, and can range from hot to mild or contain little to no vegetables. There are many variations of the delicacy, depending on type, size or shape of the cuts of meat used. Yebeg is lamb");
        foodItem.getNutritionTable().put("Calories", "378g");
        foodItem.getNutritionTable().put("Carbohydrates", "4.8g");
        foodItem.getNutritionTable().put("Protein", "7.3g");
        foodItem.getNutritionTable().put("Fat", "3.6g");
        foodItem.getNutritionTable().put("Fiber", "0.6g");
        foodItem.setServing("1");
        foodItem.setReadyTime("15");

        homeCook.getFoodItems().add(foodItem);

//5th
        foodItem = new FoodItem("Yemisser Wot", "yemesir_wot");
        foodItem.setDescription("Split red lentils simmered in berbere sauce");
        foodItem.setPrice(9.99);
        foodItem.setLongDescription("Wat is traditionally eaten with injera, a spongy flat bread made from the millet-like grain known as teff. Doro wat is one such stew, made from chicken and sometimes hard-boiled eggs; the ethnologist Donald Levine records that doro wat is the most popular traditional food in Ethiopia, often eaten as part of a group who share a communal bowl and basket of injera. Yemisser is split lentils");
        foodItem.getNutritionTable().put("Calories", "400g");
        foodItem.getNutritionTable().put("Carbohydrates", "36g");
        foodItem.getNutritionTable().put("Protein", "16g");
        foodItem.getNutritionTable().put("Fat", "10g");
        foodItem.getNutritionTable().put("Fiber", "0.7g");
        foodItem.setServing("4-5");
        foodItem.setReadyTime("60");

        homeCook.getFoodItems().add(foodItem);

//6th
        foodItem = new FoodItem("Gomen Wot", "gomen_wot");
        foodItem.setDescription("Chopped collard greens simmered in a mild sauce");
        foodItem.setPrice(8.99);
        foodItem.setLongDescription("Wat begins with a large amount of chopped red onion, which is simmered or sauteed in a pot. Once the onions have softened, niter kebbeh (or, in the case of vegan dishes, vegetable oil) is added. Following this, berbere is added to make a spicy keiy wat. Gomen is greens chopped and added to the wot");
        foodItem.getNutritionTable().put("Calories", "127g");
        foodItem.getNutritionTable().put("Carbohydrates", "9.9g");
        foodItem.getNutritionTable().put("Protein", "2.8g");
        foodItem.getNutritionTable().put("Fat", "9.6g");
        foodItem.getNutritionTable().put("Fiber", "2.9g");
        foodItem.setServing("1-3");
        foodItem.setReadyTime("40");

        homeCook.getFoodItems().add(foodItem);

//7th
        foodItem = new FoodItem("Sambussa", "sambussa");
        foodItem.setDescription("Thin dough shells stuffed with lentils, onion, hot green & herbs. This meatless dish is lightly deep fried in vegetable oil to a golden perfection");
        foodItem.setPrice(5.99);
        foodItem.setLongDescription("A samosa or samoosa is a fried or baked pastry with a savoury filling, such as spiced potatoes, onions, peas, lentils, macaroni, noodles, and/or minced meat (lamb, beef or chicken).Pine nuts can also be added. The samosa is claimed to have originated in Tanzania. Its size and consistency may vary, but typically it is distinctly triangular or tetrahedral in shape");
        foodItem.getNutritionTable().put("Calories", "186g");
        foodItem.getNutritionTable().put("Carbohydrates", "15g");
        foodItem.getNutritionTable().put("Protein", "10g");
        foodItem.getNutritionTable().put("Fat", "10g");
        foodItem.getNutritionTable().put("Fiber", "0.5g");
        foodItem.setServing("3");
        foodItem.setReadyTime("30");
        homeCook.getFoodItems().add(foodItem);

//8th
        foodItem = new FoodItem("Ethiopian Pastries", "ethiopian_pastries");
        foodItem.setDescription("cake-ish pastries that are not too sweet and range from doughy to dense. Dairy and meat free");
        foodItem.setPrice(5.99);
        foodItem.setLongDescription("Dessert is not a mainstay of Ethiopian cooking, though many Italian dishes like tiramisu and chocolate mousse have become incorporated into the cuisine. Instead, Ethiopians make cake-ish pastries that are not too sweet and range from doughy to dense. They are often fasting-approved, or dairy and meat free");
        foodItem.getNutritionTable().put("Calories", "146g");
        foodItem.getNutritionTable().put("Carbohydrates", "15.1g");
        foodItem.getNutritionTable().put("Protein", "1.7g");
        foodItem.getNutritionTable().put("Fat", "9g");
        foodItem.getNutritionTable().put("Fiber", "0.6g");
        foodItem.setServing("4-5");
        foodItem.setReadyTime("90");

        homeCook.getFoodItems().add(foodItem);


        homeCooks.add(homeCook);
        // #8 Berta's Kitchen  ------ ENDS

        // #9
        homeCook = new HomeCook("Vaino's Kitchen", "12345678", "greek.jpg");
        homeCook.setCuisine("Greek");
        homeCook.setLargeImage("vaino_kitchen");
        homeCook.getFoodItems().add(new FoodItem("Paratha", "food1"));
        homeCook.getFoodItems().add(new FoodItem("Pasta", "pasta"));
        homeCooks.add(homeCook);
        homeCook.setRating(3.0f);

        // #10
        homeCook = new HomeCook("Clara's Kitchen", "12345678", "paella.jpg");
        homeCook.setCuisine("Spanish");
        homeCook.setLargeImage("clara_kitchen");
        homeCook.getFoodItems().add(new FoodItem("Paratha", "food1"));
        homeCook.getFoodItems().add(new FoodItem("Pasta", "pasta"));
        homeCooks.add(homeCook);
        homeCook.setRating(3.5f);

    }
}
