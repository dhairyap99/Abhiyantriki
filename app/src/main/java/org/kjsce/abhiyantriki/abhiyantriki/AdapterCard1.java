package org.kjsce.abhiyantriki.abhiyantriki;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

//For all tabs in Events Section,Tech Expo,Auto Expo and Speakers
public class AdapterCard1 extends BaseAdapter {
    Context c;
    ArrayList<ModelCard1> modelCard1s;

    public AdapterCard1(Context c, ArrayList<ModelCard1> modelCard1s) {
        this.c = c;
        this.modelCard1s = modelCard1s;
    }

    @Override
    public int getCount() {
        return modelCard1s.size();
    }

    @Override
    public Object getItem(int position) {
        return modelCard1s.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(c).inflate(R.layout.model_card1, parent, false);
        }

        final ModelCard1 modelCard1 = (ModelCard1) this.getItem(position);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.img_view);
        TextView ename = (TextView) convertView.findViewById(R.id.ename);
        TextView cname = (TextView) convertView.findViewById(R.id.cname);

        imageView.setImageResource(modelCard1.getImage());
        ename.setText(modelCard1.getEname());

        if (modelCard1.hasCouncilName()) {
            cname.setText(modelCard1.getCname());
        } else {
            cname.setVisibility(View.GONE);
        }

        //For on click events
        convertView.setOnClickListener(new View.OnClickListener() {
            Intent intent;

            @Override
            public void onClick(View v) {
                //Later use images
                switch (modelCard1.getEname()) {
                    case "PUBG Mobile":
                        intent = new Intent(c, Pubg.class);
                        startActivity(c, intent, null);
                        break;
                    case "Laser Tag":
                        intent = new Intent(c, Laser.class);
                        startActivity(c, intent, null);
                        break;
                    case "Drone Racing":
                        intent = new Intent(c, Drone.class);
                        startActivity(c, intent, null);
                        break;
                    case "Meme Quest":
                        intent = new Intent(c, Meme.class);
                        startActivity(c, intent, null);
                        break;
                    case "Fifa Manager":
                        intent = new Intent(c, Fifa.class);
                        startActivity(c, intent, null);
                        break;
                    case "Counter Strike":
                        intent = new Intent(c, CS.class);
                        startActivity(c, intent, null);
                        break;
                    case "Castle Math":
                        intent = new Intent(c, CastleMath.class);
                        startActivity(c, intent, null);
                        break;
                    default:
                        Toast.makeText(c, modelCard1.ename, Toast.LENGTH_SHORT).show();
                }
            }
        });

        return convertView;
    }

}
