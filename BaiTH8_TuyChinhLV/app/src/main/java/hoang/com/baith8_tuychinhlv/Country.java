package hoang.com.baith8_tuychinhlv;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Country{
    private String Name;
    private int Flag;
    private String Population;


    public Country() {
    }
    public Country(String name, int flag, String population) {
        Name = name;
        Flag = flag;
        Population = population;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getFlag() {
        return Flag;
    }

    public void setFlag(int flag) {
        Flag = flag;
    }

    public String getPopulation() {
        return Population;
    }

    public void setPopulation(String population) {
        Population = population;
    }
}