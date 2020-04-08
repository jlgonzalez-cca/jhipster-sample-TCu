import { IACCENTIDADDF } from 'app/shared/model/accentidaddf.model';
import { IDCCCARGOENT } from 'app/shared/model/dcccargoent.model';

export interface IACCENTIDADPER {
  id?: number;
  iDENTIDAD?: number;
  iDCARGO?: number;
  nIF?: string;
  nOMBRE?: string;
  aPELLIDO1?: string;
  aPELLIDO2?: string;
  eMAIL?: string;
  aCCENTIDADDFS?: IACCENTIDADDF[];
  dCCCARGOENTS?: IDCCCARGOENT[];
}

export class ACCENTIDADPER implements IACCENTIDADPER {
  constructor(
    public id?: number,
    public iDENTIDAD?: number,
    public iDCARGO?: number,
    public nIF?: string,
    public nOMBRE?: string,
    public aPELLIDO1?: string,
    public aPELLIDO2?: string,
    public eMAIL?: string,
    public aCCENTIDADDFS?: IACCENTIDADDF[],
    public dCCCARGOENTS?: IDCCCARGOENT[]
  ) {}
}
