package com.oussema.pieces;



import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.oussema.pieces.entities.Piece;
import com.oussema.pieces.repos.PieceRepository;
import com.oussema.pieces.service.PieceService;


@SpringBootTest
class PiecesApplicationTests {

	@Autowired
	private PieceRepository pieceRepository;
	
	
	@Autowired
	PieceService pieceService;
	
	  @Test
		public void testFindByNomPieceContains()
		 {
		
			Page<Piece>  piecs = pieceService.getAllPiecesParPage(0,2);
			System.out.println(piecs.getSize());
			System.out.println(piecs.getTotalElements());
			System.out.println(piecs.getTotalPages());
			
			piecs.getContent().forEach(p -> {System.out.println(p.toString());
			                                 });	
			/*ou bien
			 for (Piece p : piecs)
			{
				System.out.println(p);
			} */
		 }

	
	/*
	@Test
	public void testCreatePiece() {
	Piece piec = new Piece("compteur",1500.500,new Date(),"renaut");
	pieceRepository.save(piec);
	}
	
	@Test
	public void testFindPiece()
	{
	Piece p = pieceRepository.findById(1L).get();
	System.out.println(p);
	}
	
	@Test
	public void testUpdatePiece()
	{
	Piece p = pieceRepository.findById(1L).get();
	p.setPrixPiece(2000.0);
	pieceRepository.save(p);
	
	System.out.println(p);
	}
	
	@Test
	public void testDeletePiece()
	{
		pieceRepository.deleteById(1L);
	}
	
	@Test
	public void testFindAllPieces()
	{
		List<Piece> piecs = pieceRepository.findAll();
		
		for (Piece p:piecs)
			 System.out.println(p);
		
	}
	*/
	
	
	
}
