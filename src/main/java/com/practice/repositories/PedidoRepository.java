package com.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entities.Pedido;


public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
