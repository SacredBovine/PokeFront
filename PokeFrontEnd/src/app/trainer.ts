import { Pokemon } from './pokemon';

export class Trainer {
    public trainerId:number;
    public name:String;
    public party:Array<Pokemon>

    constructor(tId:number, name:String, party:Array<Pokemon>){
        this.trainerId=tId,
        this.name=name,
        this.party=party
    }
}
