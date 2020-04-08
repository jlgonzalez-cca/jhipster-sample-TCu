import { IACCENTIDADPER } from 'app/shared/model/accentidadper.model';

export interface IDCCCARGOENT {
  id?: number;
  iDCARGO?: number;
  nOMBRE?: string;
  iDCARGOFK3?: IACCENTIDADPER;
}

export class DCCCARGOENT implements IDCCCARGOENT {
  constructor(public id?: number, public iDCARGO?: number, public nOMBRE?: string, public iDCARGOFK3?: IACCENTIDADPER) {}
}
