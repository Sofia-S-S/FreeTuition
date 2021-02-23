package com.freetuition.dao;

import java.util.List;

import com.freetuition.model.Card;

public interface CardRepository {

	List<Card> findAll();
	Card findByName(String name);
	void insert(Card c);
	void update(Card c);
	void delete(Card c);
}
