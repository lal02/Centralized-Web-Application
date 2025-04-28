ALTER TABLE public.temperature ALTER COLUMN value TYPE double precision USING value::double precision;
ALTER TABLE public.temperature ALTER COLUMN "timestamp" TYPE timestamp without time zone USING "timestamp"::timestamp without time zone;
