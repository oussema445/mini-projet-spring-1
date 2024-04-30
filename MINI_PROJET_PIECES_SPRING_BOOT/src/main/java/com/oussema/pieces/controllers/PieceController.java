package com.oussema.pieces.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oussema.pieces.entities.Piece;
import com.oussema.pieces.service.PieceService;

import jakarta.validation.Valid;

@Controller
public class PieceController {
	@Autowired
	PieceService pieceService;
	
	
		   @RequestMapping("/ListePieces")
			public String listeProduits(ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
										@RequestParam (name="size", defaultValue = "2") int size)
			{
			Page<Piece> piecs = pieceService.getAllPiecesParPage(page, size);
				modelMap.addAttribute("pieces", piecs);
		         modelMap.addAttribute("pages", new int[piecs.getTotalPages()]);	
				modelMap.addAttribute("currentPage", page);			
				return "listePieces";	
			}


		  
		   
		   
			


		   @RequestMapping("/savePiece")
			public String savePiece(@Valid Piece piece, BindingResult bindingResult,
					@RequestParam (name="page",defaultValue = "0") int page,
					@RequestParam (name="size", defaultValue = "2") int size)
			{
				int currentPage;
				boolean isNew = false;
			   if (bindingResult.hasErrors()) return "formPiece";				  
				
			   if(piece.getIdPiece()==null) //ajout
				    isNew=true;
			  			   
			  	pieceService.savePiece(piece);
			  	if (isNew) //ajout
			  	{
			  		Page<Piece> piecs = pieceService.getAllPiecesParPage(page, size);
			  		currentPage = piecs.getTotalPages()-1;
			  	}
			  	else //modif
			  		currentPage=page;
			  	
			  	
				//return "formPiece";
				return ("redirect:/ListePieces?page="+currentPage+"&size="+size);
			}


	  @RequestMapping("/supprimerPiece")
		public String supprimerPiece(@RequestParam("id") Long id,
				ModelMap modelMap,
				@RequestParam (name="page",defaultValue = "0") int page,
				@RequestParam (name="size", defaultValue = "2") int size)
		{

			pieceService.deletePieceById(id);
			Page<Piece> piecs = pieceService.getAllPiecesParPage(page, size);
			modelMap.addAttribute("pieces", piecs);		
			modelMap.addAttribute("pages", new int[piecs.getTotalPages()]);	
			modelMap.addAttribute("currentPage", page);	
			modelMap.addAttribute("size", size);	
			return "listePieces";	
		}



	  
	


}
