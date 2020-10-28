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

/**
 *
 * @author makefake
 */
public class DAOProduto {
    private Connection c;
    public DAOProduto(String usuario, String pass){
        this.c =new Conecta().conecta(usuario, pass);
    }
    
    
        public Produto listProdutoCodigo(Integer id){
        Produto lp =new 
        Produto();
       
        String sql="SELECT cod_produto, nome_produto, descricao_produto, imagem_produto,fg_ativo as \"fg_ativo_produto\" FROM tb_produtos where cod_produto ="+id;
        try{
             ResultSet rs;
           PreparedStatement stmt = c.prepareStatement(sql);
           rs=stmt.executeQuery();
            Produto p = new Produto();
           while(rs.next()){
              
              
              
               
               p.setCodProduto(rs.getLong("cod_produto"));
               p.setDescricaoProduto(rs.getString("descricao_produto"));
               p.setFgAtivo(rs.getBoolean("fg_ativo_produto"));
               p.setImagemProduto(rs.getString("imagem_produto"));
               p.setNomeProduto(rs.getString("nome_produto"));
               
           
               
                    

              
           }
                 lp=p;
            stmt.close();
               c.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return lp;
    }
        
        public void novoProduto(Produto pd){
            
            String sql="INSERT INTO tb_produtos(nome_produto,descricao_produto,imagem_produto, fg_ativo) VALUES(?,?,?,?)";
            
            try{
                PreparedStatement stmt = c.prepareStatement(sql);
                stmt.setString(1,pd.getNomeProduto() );
                stmt.setString(2, pd.getDescricaoProduto());
                stmt.setString(3, pd.getImagemProduto());
                stmt.setBoolean(4, true);
                
                stmt.execute();
                
                stmt.close();
                
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    
}
