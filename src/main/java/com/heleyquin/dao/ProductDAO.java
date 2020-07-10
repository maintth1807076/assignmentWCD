package com.heleyquin.dao;

import com.heleyquin.model.Category;
import com.heleyquin.model.Product;
import com.heleyquin.model.ProductSize;
import com.heleyquin.model.Size;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    EntityManagerFactory emf = new Manager().init();

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
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

    public boolean checkProductByName(String name) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT e FROM Product e WHERE e.name = ?1");
        query.setParameter(1, name);
        List<Product> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        if(list.size() > 0){
            return true;
        }
        return false;
    }

    public Size getSize(int id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Size size = em.find(Size.class, id);
        em.getTransaction().commit();
        em.close();
        return size;
    }

    public List<Product> getAllProduct(int pageNumber, int pageSize) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select c from Product c where c.status = 1", Product.class);
        query.setFirstResult((pageNumber-1) * pageSize);
        query.setMaxResults(pageSize);
        List<Product> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }
    public List<Product> getAllProduct1() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Product> list = em.createQuery("select c from Product c", Product.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    public List<Product> getAllProductWithCriteria(int categoryId, int minPrice, int maxPrice, int status, int filterId) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> productRoot = criteriaQuery.from(Product.class);
        Predicate predicate;
        List<Predicate> pr = new ArrayList<Predicate>();
        if(maxPrice > minPrice) {
            Predicate predicate3 = criteriaBuilder.lt(productRoot.get("price").as(Double.class), maxPrice);
            Predicate predicate1 = criteriaBuilder.gt(productRoot.get("price").as(Double.class), minPrice);
            pr.add(predicate3);
            pr.add(predicate1);
        }
        if(categoryId != 0){
            predicate
                    = criteriaBuilder.equal(productRoot.get("categoryId").as(Integer.class), categoryId);
            pr.add(predicate);
        }
        Predicate predicate2
                = criteriaBuilder.equal(productRoot.get("status").as(Integer.class), status);
        pr.add(predicate2);
        predicate = criteriaBuilder.and(pr.toArray(new Predicate[]{}));
        criteriaQuery.where(predicate);
        switch (filterId){
            case 1:
                criteriaQuery.orderBy(criteriaBuilder.desc(productRoot.get("createdAt")));
                break;
            case 2:
                criteriaQuery.orderBy(criteriaBuilder.asc(productRoot.get("createdAt")));
                break;
            case 3:
                criteriaQuery.orderBy(criteriaBuilder.desc(productRoot.get("name")));
                break;
            case 4:
                criteriaQuery.orderBy(criteriaBuilder.asc(productRoot.get("name")));
                break;
            default:
                criteriaQuery.orderBy(criteriaBuilder.desc(productRoot.get("createdAt")));
                break;
        }
        List<Product> items = em.createQuery(criteriaQuery).getResultList();
        return items;
    }
    public int getCountProduct() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Product> list = em.createQuery("select c from Product c where c.status = 1", Product.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return list.size();
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
        entity.setStatus(0);
        em.getTransaction().commit();
        em.close();
    }
}
