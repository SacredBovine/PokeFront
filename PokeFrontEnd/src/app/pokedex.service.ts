import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Trainer } from './trainer';
import { Observable } from 'rxjs';
import { Pokemon } from './pokemon';

@Injectable({
  providedIn: 'root'
})
export class PokedexService {
  

  constructor(private http:  HttpClient) { }

  getAllTrainers() {
      //TODO
      return this.http.get<Trainer[]>('http://localhost:8082/data/trainers')
    }
  
  getTrainer(id:number){
    return this.http.get<Trainer>('http://localhost:8082/data/trainers/'+ id.toString() +'/')
  }


  addTrainer(t:Trainer): Observable<Trainer[]> {
   //TODO
    return this.http.post<Trainer[]>("http://localhost:8082/data/trainers",t) as Observable<Trainer[]>;

  }

  getPoke(id:number): Observable<any> {
    return this.http.get<any>(('https://pokeapi.co/api/v2/pokemon/'+id+'/'))
  }

  addPoke(p:Pokemon): Observable<Trainer[]> {
   //TODO
   return this.http.post<Trainer[]>("http://localhost:8082/data/poke",p) as Observable<Trainer[]>
  }
}
