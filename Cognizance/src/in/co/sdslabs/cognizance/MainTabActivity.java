package in.co.sdslabs.cognizance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainTabActivity extends ActionBarActivity {

	private ViewPager mPager;
	ActionBar mActionBar;
	public static int day;

	public MainTabActivity() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab_layout);

		/** Getting a reference to action bar of this activity */
		mActionBar = getSupportActionBar();

		/** Set tab navigation mode */
		mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		/** Getting a reference to ViewPager from the layout */
		mPager = (ViewPager) findViewById(R.id.pager);

		/** Getting a reference to FragmentManager */
		final FragmentManager fm = getSupportFragmentManager();

		/** Defining a listener for pageChange */
		ViewPager.SimpleOnPageChangeListener pageChangeListener = new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				super.onPageSelected(position);
				mActionBar.setSelectedNavigationItem(position);
			}
		};

		/** Setting the pageChange listener to the viewPager */
		mPager.setOnPageChangeListener(pageChangeListener);

		/** Creating an instance of FragmentPagerAdapter */
		MyFragmentPagerAdapter fragmentPagerAdapter = new MyFragmentPagerAdapter(
				fm);

		/** Setting the FragmentPagerAdapter object to the viewPager object */
		mPager.setAdapter(fragmentPagerAdapter);

		mActionBar.setDisplayShowTitleEnabled(true);
		mActionBar.setDisplayHomeAsUpEnabled(true);

		/** Defining tab listener */
		ActionBar.TabListener tabListener = new ActionBar.TabListener() {

			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {

			}

			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				mPager.setCurrentItem(tab.getPosition());

				day = tab.getPosition() + 1;
			}

			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				day = tab.getPosition() + 1;
			}
		};
		/** Creating fragment1 Tab */
		Tab tab = mActionBar.newTab().setText("Day 1")
				.setTabListener(tabListener);
		mActionBar.addTab(tab);
		/** Creating fragment2 Tab */
		tab = mActionBar.newTab().setText("Day 2").setTabListener(tabListener);
		mActionBar.addTab(tab);
		/** Creating fragment3 Tab */
		tab = mActionBar.newTab().setText("Day 3").setTabListener(tabListener);
		mActionBar.addTab(tab);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    // Respond to the action bar's Up/Home button
	    case android.R.id.home:
	    	finish();
			Intent intent = new Intent(this, MainNavDrawerActivity.class);
			startActivity(intent);
	        return true;
	        
	    case R.id.filter:
			finish();
			Intent i = new Intent(this, MainNavDrawerActivity.class);
			startActivity(i);
			break;
		case R.id.map:
			// TODO : Fire intent for full map and not the zoomed in view
			Intent goToMap = new Intent(this, MapTest.class);
			startActivity(goToMap);
			break;
		case R.id.contact:

			// TODO : Fire intent for contacts activity
			Intent gotocontacts = new Intent(this, ContactListActivity.class);
			startActivity(gotocontacts);
			break;
		case R.id.about_us:
			
			Intent about_us = new Intent(this , AboutUs.class);
			startActivity(about_us);
			break;
	    }
	    return super.onOptionsItemSelected(item);
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_tab, menu);
		return true;
	}

	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		finish();
		Intent intent = new Intent(this, MainNavDrawerActivity.class);
		startActivity(intent);
	}

}