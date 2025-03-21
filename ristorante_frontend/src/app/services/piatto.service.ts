import { Injectable } from '@angular/core';
import { Piatto } from '../models/piatto.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class PiattoService {
  private apiUrl = 'http://localhost:8080/ristorante';

  constructor(private http: HttpClient) {}

  getAllPiatti(): Observable<Piatto[]> {
    return this.http.get<Piatto[]>(this.apiUrl);
  }

  addPiatto(piatto: Piatto): Observable<Piatto> {
    return this.http.post<Piatto>(this.apiUrl, piatto);
  }

  removePiatto(index: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${index}`);
  }
}
