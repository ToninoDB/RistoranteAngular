import { Categoria } from './enum/categoria.enum';

export interface Piatto {
  id?: number;
  name: string;
  price: number;
  description: string;
  category?: Categoria;
}
