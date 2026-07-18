package br.edu.arcanelibrary.modelo;

import java.util.ArrayList;

public class GerenciadorMaterial {
    private ArrayList<Material> listaMaterial;

    public GerenciadorMaterial() { listaMaterial = new ArrayList<>(); }

    public void adicionarMaterial(Material material) {
        listaMaterial.add(material);
    }

    public Material buscarMaterial(int codigo) {
        for(Material material : listaMaterial) {
            if(codigo == material.getCodigo()) {
                return material;
            }
        }
        return null;
    }

    public void removerMaterial(int codigo) {
        Material removivel = buscarMaterial(codigo);
        listaMaterial.remove(removivel);
        }

    public void listarMaterial() {
        for(Material material : listaMaterial) {
            System.out.println(material.getTitulo());
        }
    }
}



