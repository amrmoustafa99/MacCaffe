package com.example.maccoffe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import dailog.CustomDailogFragment;

public class SandwichesActivity extends AppCompatActivity {


    ArrayList<SandwichesMoudel> sandwichProducts=new ArrayList<>();

    String message="\n";
    RecyclerView recyclerView;
    TextView texttotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandwich);
       recyclerView=findViewById(R.id.recyclerview);
        texttotal=findViewById(R.id.texttotal);

        prepare();

      SandwichesAdapter sandwichesAdapter=new SandwichesAdapter(sandwichProducts,iTotalPrice);
        recyclerView.setAdapter(sandwichesAdapter);


    }

ITotalPrice iTotalPrice=new ITotalPrice() {
    @Override
    public void onpriceChanfe(int totalprice) {
        texttotal.setText("Total Price : " + totalprice + " EGP");
    }
};
   private void prepare(){
       SandwichesMoudel sandwichesMoudel1=new SandwichesMoudel("Cheesy Supreme",56,"https://www.mcdonalds.eg/Cms_Data/Contents/En/Media/images/700x474-Americano.png");
       sandwichProducts.add(sandwichesMoudel1);

       SandwichesMoudel sandwichesMoudel2=new SandwichesMoudel("Fire Wrap",25,"https://802492.smushcdn.com/1215052/wp-content/uploads/2020/09/fire-wrapp.jpg?lossy=0&strip=1&webp=1");
       sandwichProducts.add(sandwichesMoudel2);

       SandwichesMoudel sandwichesMoudel3=new SandwichesMoudel("Forrester",25,"https://802492.smushcdn.com/1215052/wp-content/uploads/2020/12/11.png?lossy=0&strip=1&webp=1");
       sandwichProducts.add(sandwichesMoudel3);

       SandwichesMoudel sandwichesMoudel4=new SandwichesMoudel("Mozzarella Madness",60,"https://802492.smushcdn.com/1215052/wp-content/uploads/2020/09/Zacks-20969.jpg?lossy=0&strip=1&webp=1");
       sandwichProducts.add(sandwichesMoudel4);

       SandwichesMoudel sandwichesMoudel5=new SandwichesMoudel("O’ranch Wrap",22,"https://802492.smushcdn.com/1215052/wp-content/uploads/2020/09/fire-wrapp.jpg?lossy=0&strip=1&webp=1");
       sandwichProducts.add(sandwichesMoudel5);

       SandwichesMoudel sandwichesMoudel6=new SandwichesMoudel("Original Wrap",26,"https://802492.smushcdn.com/1215052/wp-content/uploads/2020/09/original-wrap.jpg?lossy=0&strip=1&webp=1");
       sandwichProducts.add(sandwichesMoudel6);

       SandwichesMoudel sandwichesMoudel7=new SandwichesMoudel("Ranch Wrap",47,"https://802492.smushcdn.com/1215052/wp-content/uploads/2020/09/fire-wrapp.jpg?lossy=0&strip=1&webp=1");
       sandwichProducts.add(sandwichesMoudel7);

       SandwichesMoudel sandwichesMoudel8=new SandwichesMoudel("The Pit",57,"https://802492.smushcdn.com/1215052/wp-content/uploads/2020/09/Zacks-20910.jpg?lossy=0&strip=1&webp=1");
       sandwichProducts.add(sandwichesMoudel8);

       SandwichesMoudel sandwichesMoudel9=new SandwichesMoudel("The Rancher",35,"https://802492.smushcdn.com/1215052/wp-content/uploads/2020/09/Zacks-20910.jpg?lossy=0&strip=1&webp=1");
       sandwichProducts.add(sandwichesMoudel9);

       SandwichesMoudel sandwichesMoudel10=new SandwichesMoudel("Zack’s Classic Bite",50,"https://802492.smushcdn.com/1215052/wp-content/uploads/2020/09/Zacks-20945.jpg?lossy=0&strip=1&webp=1 ");
       sandwichProducts.add(sandwichesMoudel10);


    }

    public void ordernow(View view) {




       int totalPrice=0;


       for(int i=0; i<sandwichProducts.size(); i++){
           SandwichesMoudel sandwichesMoudel=sandwichProducts.get(i);

           if(sandwichesMoudel.Quantity !=0){
               totalPrice+=sandwichesMoudel.Quantity*sandwichesMoudel.getPrize();
               message+=sandwichesMoudel.toMessage();
           }
       }
       message+="\n Total price: "+totalPrice+" EG";
       message+="\n Amr, thanks";

        message+="\n Thank You";
/*
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ "amralshapony1@gmail.com"});
        email.putExtra(Intent.EXTRA_SUBJECT, "Coffe Order");
        email.putExtra(Intent.EXTRA_TEXT, message);

//need this to prompts email client only
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choose an Email client :"));

 */

        getSupportFragmentManager()
                .beginTransaction()
                .add(new CustomDailogFragment(totalPrice), "customDailog")
                .commit();
    }
}

