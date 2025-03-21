import { Component, OnInit } from '@angular/core';
import { Piatto } from '../models/piatto.model';
import { PiattoService } from '../services/piatto.service';
import { Categoria } from '../models/enum/categoria.enum';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-menu-list',
  imports: [FormsModule, CommonModule],
  standalone: true,
  templateUrl: './menu-list.component.html',
  styleUrls: ['./menu-list.component.css'],
})
export class MenuListComponent implements OnInit {
  piatti: Piatto[] = [];

  nuovoPiatto: Piatto = {
    name: '',
    price: 0,
    description: '',
    category: undefined,
  };

  categorie = Object.values(Categoria);

  constructor(private piattoService: PiattoService) {}

  ngOnInit(): void {
    this.caricaPiatti();
  }

  // Metodo per caricare tutti i piatti dal backend
  caricaPiatti(): void {
    this.piattoService.getAllPiatti().subscribe({
      next: (data) => (this.piatti = data),
      error: (err) => console.error('Errore nel caricamento dei piatti:', err),
    });
  }

  // Metodo per aggiungere un nuovo piatto
  aggiungiPiatto() {
    if (this.nuovoPiatto.name && this.nuovoPiatto.price) {
      this.piattoService.addPiatto({ ...this.nuovoPiatto }).subscribe({
        next: (data) => {
          console.log('Piatto aggiunto:', data);
          this.caricaPiatti(); // Aggiorna la lista dopo l'inserimento
        },
        error: (err) => console.error("Errore nell'aggiunta del piatto:", err),
      });
      // Reset del form dopo l'aggiunta
      this.nuovoPiatto = {
        name: '',
        price: 0,
        description: '',
        category: undefined,
      };
    }
  }

  // Metodo per rimuovere un piatto dal backend tramite ID
  rimuoviPiatto(id: number) {
    this.piattoService.removePiatto(id).subscribe({
      next: () => {
        console.log(`Piatto con id ${id} rimosso`);
        this.caricaPiatti(); // Aggiorna la lista dopo la rimozione
      },
      error: (err) => console.error('Errore nella rimozione del piatto:', err),
    });
  }
}
