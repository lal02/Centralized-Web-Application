CREATE TABLE public.words (
                              finnish varchar NOT NULL,
                              english varchar NOT NULL,
                              CONSTRAINT words_pk PRIMARY KEY (finnish, english)
);