package android.csulb.edu.zoodirectory;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class AnimalDetail extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);

        Intent intent = getIntent();
        String animalName = intent.getStringExtra("AnimalName");
        String animalDesc = "";
        TextView animalNameTextView = (TextView) findViewById(R.id.animalNameDetail);
        TextView animalDescTextView = (TextView) findViewById(R.id.animalDescription);
        ImageView imageView = (ImageView) findViewById(R.id.imageDetail);

        animalDescTextView.setMovementMethod(new ScrollingMovementMethod());

        switch (animalName){
            case "Lion":
                animalNameTextView.setText("LION");
                imageView.setImageResource(R.mipmap.pic1);
                animalDesc = "The lion (Panthera leo) is one of the five big cats in the genus Panthera " +
                             "and a member of the family Felidae. The commonly used term African lion collectively " +
                             "denotes the several subspecies found in Africa. With some males exceeding 250 kg " +
                             "(550 lb) in weight,[4] it is the second-largest living cat after the tiger. Wild lions " +
                             "currently exist in sub-Saharan Africa and in Asia (where an endangered remnant population " +
                             "resides in Gir Forest National Park in India) while other types of lions have disappeared " +
                             "from North Africa and Southwest Asia in historic times. " +
                             " Until the late Pleistocene, about 10,000 years ago, the lion was the most widespread large " +
                             "land mammal after humans. They were found in most of Africa, across Eurasia from western " +
                             "Europe to India, and in the Americas from the Yukon to Peru.[5] The lion is a vulnerable " +
                             "species, having seen a major population decline in its African range of 30–50% per two " +
                             "decades during the second half of the 20th century";
                animalDescTextView.setText(animalDesc);
                break;
            case "Tiger":
                animalNameTextView.setText("TIGER");
                imageView.setImageResource(R.mipmap.pic2);

                animalDesc = "The tiger (Panthera tigris) is the largest cat species, reaching a total body length " +
                        "of up to 3.38 m (11.1 ft) over curves and weighing up to 388.7 kg (857 lb) in the wild. Its " +
                        "most recognisable feature is a pattern of dark vertical stripes on reddish-orange fur with a " +
                        "lighter underside. The species is classified in the genus Panthera with the lion, leopard, jaguar " +
                        "and snow leopard. Tigers are apex predators, primarily preying on ungulates such as deer and bovids. " +
                        "They are territorial and generally solitary but social animals, often requiring large contiguous areas " +
                        "of habitat that support their prey requirements. This, coupled with the fact that they are indigenous to " +
                        "some of the more densely populated places on Earth, has caused significant conflicts with humans." +
                        "Tigers are among the most recognisable and popular of the world's charismatic megafauna. They have featured " +
                        "prominently in ancient mythology and folklore, and continue to be depicted in modern films and literature. " +
                        "They appear on many flags, coats of arms, and as mascots for sporting teams. The tiger is the national animal o" +
                        "f Bangladesh, India, Vietnam, Malaysia and South Korea.";
                animalDescTextView.setText(animalDesc);
                break;
            case "Panda":
                animalNameTextView.setText("PANDA");
                imageView.setImageResource(R.mipmap.pic3);
                animalDesc = "The giant panda (Ailuropoda melanoleuca, lit. \"black and white cat-foot\"; simplified " +
                        "Chinese: 大熊猫; traditional Chinese: 大熊貓; pinyin: dà xióng māo, lit. \"big bear cat\"),[2] " +
                        "also known as panda bear or simply panda, is a bear[3] native to south central China.[1] It is " +
                        "easily recognized by the large, distinctive black patches around its eyes, over the ears, and acr" +
                        "oss its round body. The name \"giant panda\" is sometimes used to distinguish it from the unrelat" +
                        "ed red panda. Though it belongs to the order Carnivora, the giant panda's diet is over 99% bamboo" +
                        ".[4] Giant pandas in the wild will occasionally eat other grasses, wild tubers, or even meat in th" +
                        "e form of birds, rodents or carrion. In captivity, they may receive honey, eggs, fish, yams, shrub" +
                        " leaves, oranges, or bananas along with specially prepared food.[5][6]\n" +
                        "The giant panda lives in a few mountain ranges in central China, mainly in Sichuan province, but a" +
                        "lso in neighbouring provinces, namely Shaanxi and Gansu.[7] As a result of farming, deforestation, " +
                        "and other development, the giant panda has been driven out of the lowland areas where it once lived.";
                animalDescTextView.setText(animalDesc);
                break;
            case "Deer":
                animalNameTextView.setText("DEER");
                imageView.setImageResource(R.mipmap.pic4);

                animalDesc = "Deer (singular and plural) are the ruminant mammals forming the family Cervidae. Species in " +
                        "the family include white-tailed deer, mule deer such as black-tailed deer, elk, moose, red deer, re" +
                        "indeer (caribou), fallow deer, roe deer, pudú and chital. Male deer of all species (except the Chin" +
                        "ese water deer) and female reindeer grow and shed new antlers each year. In this they differ from p" +
                        "ermanently horned animals such as antelope, which are in the same order as deer and may bear a supe" +
                        "rficial resemblance to them.\n" +
                        "The musk deer of Asia and water chevrotain (or mouse deer) of tropical African and Asian forest" +
                        "s are not usually regarded as true deer and form their own families: Moschidae and Tragulidae, res" +
                        "pectively."+"Deer live in a variety of biomes, ranging from tundra to the tropical rainforest. Whi" +
                        "le often associated with forests, many deer are ecotone species that live in transitional areas bet" +
                        "ween forests and thickets (for cover) and prairie and savanna (open space). The majority of large de" +
                        "er species inhabit temperate mixed deciduous forest, mountain mixed coniferous forest, tropical seas" +
                        "onal/dry forest, and savanna habitats around the world. Clearing open areas within forests to some ex" +
                        "tent may actually benefit deer populations by exposing the understory and allowing the types of grass" +
                        "es, weeds, and herbs to grow that deer like to eat. Additionally, access to adjacent croplands may al" +
                        "so benefit deer. However, adequate forest or brush cover must still be provided for populations to gro" +
                        "w and thrive.";
                animalDescTextView.setText(animalDesc);
                break;
            case "Bear":
                animalNameTextView.setText("BEAR");
                imageView.setImageResource(R.mipmap.pic5);

                animalDesc = "Bears are mammals of the family Ursidae. Bears are classified as caniforms, or doglike carni" +
                        "vorans, with the pinnipeds being their closest living relatives. Although only eight species of b" +
                        "ears are extant, they are widespread, appearing in a wide variety of habitats throughout the North" +
                        "ern Hemisphere and partially in the Southern Hemisphere. Bears are found on the continents of No" +
                        "rth America, South America, Europe, and Asia.\n" +
                        "\n" +
                        "Common characteristics of modern bears include large bodies with stocky legs, long snouts, shag" +
                        "gy hair, plantigrade paws with five nonretractile claws, and short tails. While the polar bear i" +
                        "s mostly carnivorous, and the giant panda feeds almost entirely on bamboo, the remaining six spe" +
                        "cies are omnivorous with varied diets.\n" +
                        "\n" +
                        "With the exception of courting individuals and mothers with their young, bears are typically so" +
                        "litary animals. They are generally diurnal, but may be active during the night (nocturnal) or tw" +
                        "ilight (crepuscular), particularly around humans. Bears possess an excellent sense of smell and, des" +
                        "pite their heavy build and awkward gait, are adept runners, climbers, and swimmers. In autumn, som" +
                        "e bear species forage large amounts of fermented fruits, which affects their behaviour.[1] Bears us" +
                        "e shelters, such as caves and burrows, as their dens; most species occupy their dens during the wi" +
                        "nter for a long period (up to 100 days) of sleep similar to hibernation.[2]";
                animalDescTextView.setText(animalDesc);
                break;
        }




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_animal_listing, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.information) {
            Intent informationIntent = new Intent(AnimalDetail.this, ZooInformation.class);
            startActivity(informationIntent);
        }

        if(id == R.id.uninstall){
            Uri packageURI = Uri.parse("package:android.csulb.edu.zoodirectory");
            Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
            startActivity(uninstallIntent);
        }

        return super.onOptionsItemSelected(item);
    }
}
