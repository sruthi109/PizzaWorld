package com.example.pizzaworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pizzaworld.model.PojoDetails;
import com.example.pizzaworld.ui.home.HomeFragment;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class  Details extends AppCompatActivity {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth mAuth;
    private  TextView textDescription,textprice,quantity, textname;
    int quantt;
    String price;
    double totall;
    String quant,ttt,disCusto;
    Button cancel,cart;
    CollectionReference reference = db.collection("AddToCart");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mAuth = FirebaseAuth.getInstance();
        final String userId = mAuth.getCurrentUser().getEmail();

        cancel=findViewById(R.id.cancel);
        cart=findViewById(R.id.cart);
        price= (String) getIntent().getExtras().get("price");
        disCusto=getIntent().getExtras().getString("disCusto");
        String name = getIntent().getExtras().getString("name");
        textname = (TextView) findViewById(R.id.textname);
        textprice = (TextView) findViewById(R.id.textprice);
        ImageView imagepizza=findViewById(R.id.imagePizza);
        quantity=findViewById(R.id.textQuantity);
        Button add=findViewById(R.id.add);
        Button sub=findViewById(R.id.sub);
        textDescription = (TextView) findViewById(R.id.description);
        textname.setText(name);
        Bundle bundle=getIntent().getExtras();
        int image=bundle.getInt("image");
        imagepizza.setImageResource(image);
        Double temp=Double.parseDouble(price);
        textprice.setText("$"+temp);


        quant= quantity.getText().toString();
        quantt = Integer.parseInt(quant);


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Details.this,MainActivity.class);
                startActivity(i);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(quantt<=49) {
                    int a= quantt+1;
                    String qqq=String.valueOf(a);
                    quantity.setText(qqq);
                    totall = Double.parseDouble(price)*a;
                    ttt=String.valueOf(totall);
                    textprice.setText("$"+ttt);
                    //  Toast.makeText(Details.this,"quantt"+a,Toast.LENGTH_SHORT).show();
                }
                else if (quantt == 50)

                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Details.this);
                    builder.setMessage("The Quantity of Pizza must not be more than 50")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                    return;
                }
                else {
                    Toast.makeText(Details.this,"hey i am mad",Toast.LENGTH_SHORT).show();
                    return;
                }

                quantt= quantt+1;
            }
        });


        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quantt>1) {
                    int x = quantt - 1;
                    String qqq = String.valueOf(x);
                    quantity.setText(qqq);
                    totall = Double.parseDouble(price) * x;
                    String ttt = String.valueOf(totall);
                    textprice.setText("$"+ttt);
                }

                else if (quantt==1){

                    AlertDialog.Builder builder = new AlertDialog.Builder(Details.this);
                    builder.setMessage("The Quantity of Pizza must not be less than 1")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                    return;

                }
                else {
                    Toast.makeText(Details.this,"hey i am mad",Toast.LENGTH_SHORT).show();
                    return;
                }
                quantt=quantt-1;

            }
        });
        if(name.equals("Customised Pizza")){
            textDescription.setText(disCusto);

        }


        if (name.equals("Super Veggie Pizza"))
        {
            String des="When you want to jazz up your cheese pizza with color and texture, veggies are the perfect topping. And you’re only limited by your imagination. Everything from peppers and mushrooms, to eggplant and onions make for an exciting and tasty veggie pizza.";
            textDescription.setText(des);

        }

        if (name.equals("Hawaiian Pizza"))
        {
            String des="Pineapple might not be the first thing that comes to mind when you think pizza. But add in some ham and it creates an unexpectedly solid sweet and salty combination for this type of pizza.";
            textDescription.setText(des);
        }
        if (name.equals("Meat Pizza"))
        {
            String des="If pepperoni just isn’t enough, and you’re looking for a pie with a bit more heft, a meat pizza is a perfect and popular choice. Pile on ground beef and sausage for a hearty meal.";
            textDescription.setText(des);
        }
        if (name.equals("BBQ Chicken Pizza"))
        {
            String des="If you love BBQ chicken and you love pizza, why not put them together? This has long been a cult favorite of sports fans and college kids. The chicken slathered over the top of a pie gives it a tangy, sweet flavor that can’t be beaten.";
            textDescription.setText(des);
        }
        if(name.equals("Pepporoni Pizza"))
        {
            String des="There’s a reason this is one of the most popular types of pizza. Who doesn’t love biting into a crispy, salty round of pepperoni?";
            textDescription.setText(des);
        }
        if(name.equals("Supreme Pizza"))
        {
            String des="When you can’t decide which toppings to get, it’s time for the supreme pizza. The “supreme” refers to the litany of toppings that come scattered on these pies, from sausage to vegetables to pepperoni. And it’s the combination of the flavors that really makes it sing.";
            textDescription.setText(des);
        }
        if(name.equals("Work Pizza"))
        {
            String des="And when the supreme just isn’t enough, you’re ready for the works. It’s a step up in heartiness from the supreme. The “works” usually involves a wide variety of veggie toppings including onions, olives, and mushrooms, plus bacon and pepperoni";
            textDescription.setText(des);
        }
        if(name.equals("Cheese Pizza"))
        {
            String des="It should be no shocker that a classic is the statistical favorite. Cheese pizza is one of the most popular choices. It will always be a simple, unadorned masterpiece on its own.";
            textDescription.setText(des);
        }
        if(name.equals("Buffalo Pizza"))
        {
            String des="Who says your pizza has to be strictly tomato-sauce based? Branch out with some buffalo sauce on your pie. All its spicy, salty, buttery goodness is a natural pairing for pizza." ;
            textDescription.setText(des);
        }
        if(name.equals("Margherita Pizza"))
        {
            String des="Deceptively simple, the Margherita pizza is made with basil, fresh mozzarella, and tomatoes. There’s a reason it’s an Italian staple and one of the most popular types of pizza in the country." ;
            textDescription.setText(des);
        }

        if(name.equals("Mellow Mushroom"))
        {
            String des="The Mellow Mushroom serves up all your classic pies, but with flair. The BBQ Chicken comes with bacon, cheddar, and caramelized onion. The Mighty Meaty includes both ham andbacon, along with ground beef, sausage, and pepperoni. Or try the Magical Mystery Tour, a pesto-based pie with spinach, mushroom, feta, and jalapenos." ;
            textDescription.setText(des);
        }

        if(name.equals(" Verdugo Pizza"))
        {
            String des="Verdugo Pizza is family owned, and it shows. They hand-toss every pie to order. And you can choose from crowd-pleasing options like Margherita and Pesto Chicken." ;
            textDescription.setText(des);
        }

        if (name.equals("Chicken Bites"))
        {
            String des="You just can’t say no to chicken nuggets, especially when they’re cooked to absolute crisp-perfection, loaded with that freshly grated Parmesan. And it’s sure to bring out the kid in you as you dunk these bad boys in ketchup and honey mustard!";
            textDescription.setText(des);

        }

        if (name.equals("Wing It Box"))
        {
            String des="8pcs wings, 8pcs bites + choice of 2 fried items: 8 jalapeno poppers / 8 deep fried pickles / potato wedges / fries / onion rings";
            textDescription.setText(des);

        }
        if (name.equals("Pizza With Fries"))
        {
            String des="Surprise and delight your loved ones with a delectable serving of Pepperoni Pizza Fries. Waffle fries are topped with premade pizza sauce, mozzarella and pepperoni for a taste like no other. Pepperoni Pizza Fries brings together two of their favorite taste combos, pizza and French fries!";
            textDescription.setText(des);

        }
        if (name.equals("2 Large Pizza With Drinks"))
        {
            String des="2 Large Pizzas with 4 toppings combined, 4 Drinks and 2 Dips 440-835 Cals/Serving, Serves 10";
            textDescription.setText(des);

        }
        if (name.equals("Fries,Nuggets+Drinks"))
        {
            String des="Its a great deal for a couple friends chilling and wanting cheap food to feed everyone.";
            textDescription.setText(des);
        }
        if (name.equals("Pizza and Wings Deal"))
        {
            String des="Large 3-topping pizza, 10pcs wings, 4 drinks and 2 dips \n" +
                    "Starting from $24.99\n" +
                    " 680 To 1440 Cals/Serving, Serves 5\n";
            textDescription.setText(des);
        }

        if (name.equals("Flavoured Sparkling Water"))
        {
            String des="New AHA Flavoured Sparkling Water! Choose from 2 refreshing flavours: Lime Watermelon or Peach Honey\n"
                    +"0 To 220 Cals/Bottle\n";
            textDescription.setText(des);
        }

        if (name.equals("Nestea"))
        {
            String des="160 Cals";
            textDescription.setText(des);
        }
        if (name.equals("Marble Brownies"))
        {
            String des="worlds best fudgiest brownies is our best brownie recipe! perfect crisp crackly top, super fudgy centre, chewy or gooey in all the right places, studded with melted chunks of chocolate.\n"+
                    "100 Cals\n";
            textDescription.setText(des);
        }
        if (name.equals("Speciality Chicken"))
        {
            String des="200 Cals";
            textDescription.setText(des);
        }
        if (name.equals("Bottled Water"))
        {
            String des="Dasani 591mL Bottled water\n"+"0 Cals\n";
            textDescription.setText(des);
        }
        if (name.equals("Monster Original"))
        {
            String des="210 Cals";
            textDescription.setText(des);
        }
        if (name.equals("Lava Cake"))
        {
            String des="25 Cals";
            textDescription.setText(des);
        }
        if (name.equals("Chicken Wings"))
        {
            String des="150 Cals";
            textDescription.setText(des);
        }
        if (name.equals("Can Pop"))
        {
            String des="Choose from a variety of Coke products. Available in 355 mL cans.\n" +
                    "\n" +
                    "0 To 160 Cals/Can";
            textDescription.setText(des);
        }
        if (name.equals("Bottle Pop"))
        {
            String des="Choose from a variety of Coke products. Available in 500 mL bottles.\n" +
                    "\n" +
                    "0 To 220 Cals/Bottle";
            textDescription.setText(des);
        }
        if (name.equals("French Fries"))
        {
            String des= "0 To 65 Cals/Bottle";
            textDescription.setText(des);
        }
        if (name.equals("Supreme Energetic Poutine"))
        {
            String des= "0 To 250 Cals/Bottle";
            textDescription.setText(des);
        }



        //add to cart
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pizzaname=textname.getText().toString();
                String price=textprice.getText().toString();
                String quantuu=quantity.getText().toString();
                String des=textDescription.getText().toString();
                String status="Cart";
                String totalprice="";
                String address="";
                Toast.makeText(Details.this,"bdbd"+pizzaname,Toast.LENGTH_SHORT).show();
                //  if (!hasValidationErrors(name, price, quantuu, des, status)) {

                CollectionReference reference = db.collection("AddToCart");

                PojoDetails PojoDetails = new PojoDetails(pizzaname,price, quantuu, des, status,totalprice,address, userId);

                reference.add(PojoDetails).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(Details.this, "Data Added Successfully", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Details.this, "e.toString()", Toast.LENGTH_SHORT).show();
                    }
                });

                //finish();


                Intent i=new Intent(Details.this, MainActivity.class);
                startActivity(i);

            }
            //   }


        });


    }
}