package com.oussema.pieces.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.oussema.pieces.entities.Nature;
import com.oussema.pieces.entities.Piece;

public interface PieceService {
	Piece savePiece(Piece p);
	Piece updatePiece(Piece p);
	void deletePiece(Piece p);
	void deletePieceById(Long id);
	Piece getPiece(Long id);
	List<Piece> getAllPieces();
	
	Page<Piece> getAllPiecesParPage(int page, int size);
	
	List<Nature> getAllNatures();
	


}
