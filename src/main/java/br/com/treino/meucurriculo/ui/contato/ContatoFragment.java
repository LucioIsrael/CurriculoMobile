package br.com.treino.meucurriculo.ui.contato;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.treino.meucurriculo.R;
import mehdi.sakout.aboutpage.AboutPage;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContatoFragment extends Fragment {

    public ContatoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String descrição = "As redes sociais que eu mais utilizo estão logo abaixo." +
                " Entrando no meu GitHub você pode encontrar todos os meus projetos e acompanhar a minha evolução como desenvolvedor mobile." +
                " No meu linkedIn você pode ver todas as minhas postagens referentes ao trabalho e a minha experiencia profissional";

       return new AboutPage(getActivity())
               .isRTL(false)
               .setImage(R.drawable.imgtes)
               .setDescription(descrição)
               .addGroup("Entre em contato")
               .addEmail("lucioisraelti@gmail.com", "Envie um Email")
               .addGroup("Redes sociais")
               .addGitHub("LucioIsrael", "Meu GitHub")
               .addWebsite("https://www.linkedin.com/in/lucioisrael/", "Meu LinkedIn")
               .addInstagram("lucio_stan/", "Meu Instagram")
               .create();

    }
}