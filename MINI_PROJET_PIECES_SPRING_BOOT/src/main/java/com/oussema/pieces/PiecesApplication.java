package com.oussema.pieces;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.oussema.pieces.entities.Piece;
import com.oussema.pieces.service.PieceService;

@SpringBootApplication
public class PiecesApplication implements CommandLineRunner  {
	
	@Autowired 
	PieceService pieceService;

	public static void main(String[] args) {
		SpringApplication.run(PiecesApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	
	pieceService.savePiece(new Piece("Imp ", 900.0, new Date(),"tous les model"));
	
		
	}

}
