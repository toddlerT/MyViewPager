package parlicom.myviewpager.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import parlicom.myviewpager.R;
import parlicom.myviewpager.dimensionalpager.DimensionalAdapter;
import parlicom.myviewpager.dimensionalpager.verticalpager.VerticalPagerAdapter;
import parlicom.myviewpager.dimensionalpager.verticalpager.VerticalViewPager;
import parlicom.myviewpager.fragment.FirstColumnTwo;
import parlicom.myviewpager.fragment.FirstColumnlOne;
import parlicom.myviewpager.fragment.SecondColumnOne;
import parlicom.myviewpager.fragment.SecondCoulumnTwo;

public class MainActivity extends AppCompatActivity {

    private List<View> baseList;

    private ViewPager dimensionalPager;
    private DimensionalAdapter dimensionalAdapter;


    private Fragment firstColumnOne,firstColumnTwo,secondColumnOne,secondColumnTwo;
    private List<Fragment> firstColumnFragment,secondColumnFragment;
    private VerticalPagerAdapter firstColumnAdapter,secondColumnAdapter;
    private VerticalViewPager firstColumnPager,secondColumnPager;

    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dimensionalPager = (ViewPager)findViewById(R.id.dimensional_pager);

        inflater = LayoutInflater.from(this);
        View firstColumnLayout = inflater.inflate(R.layout.pager_first_column,null);
        firstColumnPager = (VerticalViewPager) firstColumnLayout.findViewById(R.id.first_column_pager);

        View secondColumnLayout = inflater.inflate(R.layout.pager_second_column,null);
        secondColumnPager = (VerticalViewPager) secondColumnLayout.findViewById(R.id.second_column_pager);
        initialization();

        firstColumnPager.setAdapter(firstColumnAdapter);
        secondColumnPager.setAdapter(secondColumnAdapter);

        baseList = new ArrayList<View>();
        baseList.add(firstColumnPager);
        baseList.add(secondColumnPager);

        dimensionalAdapter = new DimensionalAdapter(baseList);
        dimensionalPager.setAdapter(dimensionalAdapter);


    }

    public void initialization(){
        firstColumnOne = new FirstColumnlOne();
        firstColumnTwo = new FirstColumnTwo();
        secondColumnOne = new SecondColumnOne();
        secondColumnTwo = new SecondCoulumnTwo();

        firstColumnFragment = new ArrayList<Fragment>();
        firstColumnFragment.add(firstColumnOne);
        firstColumnFragment.add(firstColumnTwo);
        firstColumnAdapter = new VerticalPagerAdapter(
                getSupportFragmentManager(),firstColumnFragment
        );

        secondColumnFragment = new ArrayList<Fragment>();
        secondColumnFragment.add(secondColumnOne);
        secondColumnFragment.add(secondColumnTwo);
        secondColumnAdapter = new VerticalPagerAdapter(
                getSupportFragmentManager(),secondColumnFragment
        );


    }
}
