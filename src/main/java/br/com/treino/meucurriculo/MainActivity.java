package br.com.treino.meucurriculo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import br.com.treino.meucurriculo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();
            }
        });
        //binding.appBarMain.fab2.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View view) {
            //    enviarGitHub();
          //  }
        //});
        //binding.appBarMain.fab3.setOnClickListener(new View.OnClickListener() {
           // @Override
            //public void onClick(View view) {
          //      enviarLinkedin();
         //   }
       // });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_tools, R.id.nav_sobre, R.id.nav_contatos)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void enviarEmail(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(intent.EXTRA_EMAIL, new String[]{"lucioisraelti@gmail.com", "lucioinvestidor2021@gmail.com"});
        intent.putExtra(intent.EXTRA_SUBJECT, "Contato pelo app");
        intent.putExtra(intent.EXTRA_TEXT, "Olá Lúcio");

        //mime types
        intent.setType("message/rfc822");

        startActivity(Intent.createChooser(intent, "Escolha um aplicativo de Email"));

    }

    //public void enviarLinkedin(){
        //String linkedin = "https://www.linkedin.com/in/lucioisrael/";
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkedin));
        //startActivity(intent);
    //}

    //public void enviarGitHub(){
        //String github = "https://github.com/LucioIsrael";
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(github));
        //startActivity(intent);
    //}



    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}