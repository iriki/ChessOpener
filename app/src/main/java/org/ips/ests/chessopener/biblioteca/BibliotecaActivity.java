package org.ips.ests.chessopener.biblioteca;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import org.ips.ests.chessopener.R;
import org.ips.ests.chessopener.Start;
import org.ips.ests.chessopener.model.Opening;
import org.ips.ests.chessopener.ui.SlidingTabLayout;
import org.ips.ests.chessopener.ui.ViewPagerAdapter;
import org.ips.ests.chessopener.utils.OpeningUtils;

public class BibliotecaActivity extends ActionBarActivity
        implements NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private Toolbar mToolbar;

    ViewPager pager;
    ViewPagerAdapter adapter;
    /** The tabs of the ViewPager */
    SlidingTabLayout tabs;
    /** The titles of the Tabs */
    CharSequence Titles[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biblioteca);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);

        Titles = new CharSequence[] {
                getString(R.string.tab_description),
                getString(R.string.tab_history),
                getString(R.string.tab_video)
        };

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.fragment_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);
        // populate the navigation drawer
        mNavigationDrawerFragment.setUserData("Chess Opener", "GNU GPL Licence v2",
                BitmapFactory.decodeResource(getResources(), R.drawable.avatar));

        // If we have an Opening object coming from the bundle instantiate it, if not, use the
        // first opening from the array.
        Opening opening = Start.openings.get(0);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            try {
                opening = (Opening) bundle.getSerializable(Opening.OPENING_BUNDLE_KEY);
            } catch (Exception ignored) {
            }
        }

        // Changes the Toolbar's name to the Opening name
        getSupportActionBar().setTitle(opening.getName());

        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles for the Tabs and Number Of Tabs.
        // Instantiates the adapter with the Opening object if not null, or the first Opening from the model
        adapter =  new ViewPagerAdapter(getSupportFragmentManager(), Titles, Titles.length, opening);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        // Assigning the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);

        // Hack to make the NavDrawer select the opening coming from the Intent
        mNavigationDrawerFragment.onNavigationDrawerItemSelected(OpeningUtils.findPositionFromString(opening.getName(), Start.openings));


    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        //Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();

        Opening opening = Start.openings.get(position);

        if (adapter != null) {
            pager.setAdapter(adapter);
            adapter.update(opening);
        }
        if (mToolbar != null && opening != null) {
            mToolbar.setTitle(opening.getName());
        }
    }

    @Override
    public void onBackPressed() {
        if (mNavigationDrawerFragment.isDrawerOpen())
            mNavigationDrawerFragment.closeDrawer();
        else
            super.onBackPressed();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.biblioteca, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}