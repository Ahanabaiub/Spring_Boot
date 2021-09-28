package com.ahanab.simpleapp.data;


import com.ahanab.simpleapp.Ingredient;

public interface IngredientRepository {

  Iterable<Ingredient> findAll();
  
  Ingredient findById(String id);
  
  Ingredient save(Ingredient ingredient);
  
}
