package com.canuto.demo.repositories;

import com.canuto.demo.domain.Categoria;
import com.canuto.demo.domain.QCategoria;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria, UUID>, QuerydslPredicateExecutor<Categoria>, QuerydslBinderCustomizer<QCategoria> {

    @Override
    default public void customize(QuerydslBindings bindings, QCategoria root) {
        bindings.bind(String.class)
                .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
    }

}
