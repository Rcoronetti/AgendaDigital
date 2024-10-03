package com.coronetti.agendadigital;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.coronetti.agendadigital.databinding.ActivityMainBinding;

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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .setAnchorView(R.id.fab).show();
            }
        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // Definindo as IDs para incluir a nova HomeFragment
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_mural, R.id.nav_tarefas, R.id.nav_informacoes)
                .setOpenableLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        // Adicionar o listener para os itens do NavigationView
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                // Aqui gerenciamos a navegação
                int id = item.getItemId();
                if (id == R.id.nav_mural) {
                    navController.navigate(R.id.nav_mural); // Navegar para o Mural
                } else if (id == R.id.nav_tarefas) {
                    navController.navigate(R.id.nav_tarefas); // Navegar para TarefasFragment
                } else if (id == R.id.nav_criacao_tarefas) {
                    navController.navigate(R.id.nav_criacao_tarefas); //Navegar para CriacaoTarefasFragment
                }else if (id == R.id.nav_acompanhamento_tarefas) {
                    navController.navigate(R.id.nav_acompanhamento_tarefas); //Navegar para AcompanhamentoTarefasFragment
                }else if (id == R.id.nav_informacoes) {
                    navController.navigate(R.id.nav_informacoes); // Navegar para InformacoesFragment
                }
                binding.drawerLayout.closeDrawers(); // Fechar o Navigation Drawer
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        if (navController.getCurrentDestination().getId() == R.id.nav_mural) {
            super.onBackPressed(); // O padrão de comportamento do botão de voltar
        } else {
            navController.popBackStack(); // Retorna ao destino anterior
        }
    }
}
