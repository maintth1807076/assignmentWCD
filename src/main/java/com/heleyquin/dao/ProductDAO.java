package com.heleyquin.dao;

import com.heleyquin.model.Product;
import com.heleyquin.model.ProductSize;
import com.heleyquin.model.Size;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProductDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager em = emf.createEntityManager();

    public void insertProduct(Product product) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
        em.close();
    }

    public Product getProduct(int id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Product product = em.find(Product.class, id);
        em.getTransaction().commit();
        em.close();
        return product;
    }

    public Size getSize(int id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Size size = em.find(Size.class, id);
        em.getTransaction().commit();
        em.close();
        return size;
    }

    public List<Product> getAllProduct() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Product> list = em.createQuery("select c from Product c", Product.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    public List<Size> getAllSize() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Size> list = em.createQuery("select c from Size c", Size.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    public void updateProduct(Product product) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Product entity = em.find(Product.class, product.getId());
        entity.setName(product.getName());
        entity.setPrice(product.getPrice());
        entity.setThumbnail(product.getThumbnail());
        entity.setDescription(product.getDescription());
        entity.setCategory(product.getCategory());
        entity.setProductSizeList(product.getProductSizeList());
        entity.setCategoryId(product.getCategoryId());
        em.getTransaction().commit();
        em.close();
    }

    public void deleteProduct(int id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Product entity = em.find(Product.class, id);
        em.remove(entity);
        em.getTransaction().commit();
        em.close();
    }
}
