/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Produto;
import model.ProdutosPrecos;

/**
 *
 * @author makefake
 */
public class DAOProdutosPrecos {
    private Connection c;
    public DAOProdutosPrecos(String usuario, String pass){
        this.c = new Conecta().conecta(usuario, pass);
    }
    
    
    public List<ProdutosPrecos> listarTudo(){
        List<ProdutosPrecos> lp =new ArrayList<ProdutosPrecos>();
       
        String sql="SELECT p.cod_produto,p.nome_produto,p.descricao_produto,p.fg_ativo as 'fg_ativo_produto',p.imagem_produto,pp.cod_produtos_precos,pp.fg_ativo,pp.preco_produto,pp.peso,pp.un_medida FROM tb_produtos as p INNER JOIN tb_produtos_precos as pp on p.cod_produto = pp.cod_produto where pp.fg_ativo = true and p.fg_ativo= true;";
        try{
             ResultSet rs;
           PreparedStatement stmt = c.prepareStatement(sql);
           rs=stmt.executeQuery();
           
           while(rs.next()){
               ProdutosPrecos pp = new ProdutosPrecos();
               Produto p = new Produto();
               pp.setCodProdutosPrecos(rs.getLong("cod_produtos_precos"));
               pp.setFgAtivo(rs.getBoolean("fg_ativo_produto"));
               pp.setPeso(rs.getDouble("peso"));
               pp.setUnMedida(rs.getString("un_medida"));
               pp.setPrecoProduto(rs.getDouble("preco_produto"));
               
               p.setCodProduto(rs.getLong("cod_produto"));
               p.setDescricaoProduto(rs.getString("descricao_produto"));
               p.setFgAtivo(rs.getBoolean("fg_ativo_produto"));
               p.setImagemProduto(rs.getString("imagem_produto"));
               p.setNomeProduto(rs.getString("nome_produto"));
               
               pp.setCodProduto(p);
               
               lp.add(pp);
           }
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return lp;
    }
    
    
    public ProdutosPrecos listarPorFiltro(Long codProduto){
        ProdutosPrecos pp = new ProdutosPrecos();
       
        String sql="SELECT p.cod_produto,p.nome_produto,p.descricao_produto,p.fg_ativo as 'fg_ativo_produto',p.imagem_produto,pp.cod_produtos_precos,pp.fg_ativo,pp.preco_produto,pp.peso,pp.un_medida FROM tb_produtos as p INNER JOIN tb_produtos_precos as pp on p.cod_produto = pp.cod_produto where pp.fg_ativo = true and p.fg_ativo= true and p.cod_produto ="+codProduto;
        try{
             ResultSet rs;
           PreparedStatement stmt = c.prepareStatement(sql);
           rs=stmt.executeQuery();
           
           while(rs.next()){
              
               Produto p = new Produto();
               pp.setCodProdutosPrecos(rs.getLong("cod_produtos_precos"));
               pp.setFgAtivo(rs.getBoolean("fg_ativo_produto"));
               pp.setPeso(rs.getDouble("peso"));
               pp.setUnMedida(rs.getString("un_medida"));
               pp.setPrecoProduto(rs.getDouble("preco_produto"));
               
               p.setCodProduto(rs.getLong("cod_produto"));
               p.setDescricaoProduto(rs.getString("descricao_produto"));
               p.setFgAtivo(rs.getBoolean("fg_ativo_produto"));
               p.setImagemProduto(rs.getString("imagem_produto"));
               p.setNomeProduto(rs.getString("nome_produto"));
               
               pp.setCodProduto(p);
               
              
           }
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return pp;
    }
}
