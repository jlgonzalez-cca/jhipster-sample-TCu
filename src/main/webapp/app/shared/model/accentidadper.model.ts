import { IACCENTIDADDF } from 'app/shared/model/accentidaddf.model';
import { IDCCCARGOENT } from 'app/shared/model/dcccargoent.model';

export interface IACCENTIDADPER {
  id?: number;
  nIF?: string;
  nOMBRE?: string;
  aPELLIDO1?: string;
  aPELLIDO2?: string;
  eMAIL?: string;
  iDENTIDADFK2?: IACCENTIDADDF;
  iDCARGOFK3?: IDCCCARGOENT;
}

export class ACCENTIDADPER implements IACCENTIDADPER {
  constructor(
    public id?: number,
    public nIF?: string,
    public nOMBRE?: string,
    public aPELLIDO1?: string,
    public aPELLIDO2?: string,
    public eMAIL?: string,
    public iDENTIDADFK2?: IACCENTIDADDF,
    public iDCARGOFK3?: IDCCCARGOENT
  ) {}
}
