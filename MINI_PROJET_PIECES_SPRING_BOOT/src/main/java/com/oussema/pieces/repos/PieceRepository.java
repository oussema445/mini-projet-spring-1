package com.oussema.pieces.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oussema.pieces.entities.Piece;

public interface PieceRepository extends JpaRepository<Piece, Long> {

}
