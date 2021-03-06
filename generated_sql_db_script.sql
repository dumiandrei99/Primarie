PGDMP         !                y            primarie    13.2    13.2     ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    29178    primarie    DATABASE     l   CREATE DATABASE primarie WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE primarie;
                postgres    false            ?            1259    40343    cereri    TABLE     ?  CREATE TABLE public.cereri (
    id_column bigint NOT NULL,
    user_id_column character varying(50) NOT NULL,
    tip_cerere_column character varying(50) NOT NULL,
    data_column character varying(50) NOT NULL,
    nume_column character varying(50) NOT NULL,
    prenume_column character varying(50) NOT NULL,
    adresa_column character varying(50) NOT NULL,
    numar_cereri_column integer NOT NULL,
    aprobare_column character varying(50) NOT NULL
);
    DROP TABLE public.cereri;
       public         heap    postgres    false            ?            1259    40341    cereri_id_column_seq    SEQUENCE     }   CREATE SEQUENCE public.cereri_id_column_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.cereri_id_column_seq;
       public          postgres    false    203            ?           0    0    cereri_id_column_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.cereri_id_column_seq OWNED BY public.cereri.id_column;
          public          postgres    false    202            ?            1259    40334 	   documente    TABLE     ?   CREATE TABLE public.documente (
    id_doc_column character varying(50) NOT NULL,
    tip_column character varying(50) NOT NULL
);
    DROP TABLE public.documente;
       public         heap    postgres    false            ?            1259    40359    locuinte    TABLE     9  CREATE TABLE public.locuinte (
    id_locuinta_column character varying(50) NOT NULL,
    id_propietar_column character varying(50) NOT NULL,
    nume_propietar_column character varying(50) NOT NULL,
    prenume_propietar_column character varying(50) NOT NULL,
    adresa_column character varying(50) NOT NULL
);
    DROP TABLE public.locuinte;
       public         heap    postgres    false            ?            1259    40329    users    TABLE     K  CREATE TABLE public.users (
    id_column character varying(50) NOT NULL,
    tip_user_column character varying(50) NOT NULL,
    username_column character varying(50) NOT NULL,
    password_column character varying(50) NOT NULL,
    nume_column character varying(50) NOT NULL,
    prenume_column character varying(50) NOT NULL
);
    DROP TABLE public.users;
       public         heap    postgres    false            .           2604    40346    cereri id_column    DEFAULT     t   ALTER TABLE ONLY public.cereri ALTER COLUMN id_column SET DEFAULT nextval('public.cereri_id_column_seq'::regclass);
 ?   ALTER TABLE public.cereri ALTER COLUMN id_column DROP DEFAULT;
       public          postgres    false    203    202    203            ?          0    40343    cereri 
   TABLE DATA           ?   COPY public.cereri (id_column, user_id_column, tip_cerere_column, data_column, nume_column, prenume_column, adresa_column, numar_cereri_column, aprobare_column) FROM stdin;
    public          postgres    false    203          ?          0    40334 	   documente 
   TABLE DATA           >   COPY public.documente (id_doc_column, tip_column) FROM stdin;
    public          postgres    false    201   ?       ?          0    40359    locuinte 
   TABLE DATA           ?   COPY public.locuinte (id_locuinta_column, id_propietar_column, nume_propietar_column, prenume_propietar_column, adresa_column) FROM stdin;
    public          postgres    false    204   Y       ?          0    40329    users 
   TABLE DATA           z   COPY public.users (id_column, tip_user_column, username_column, password_column, nume_column, prenume_column) FROM stdin;
    public          postgres    false    200   O        ?           0    0    cereri_id_column_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.cereri_id_column_seq', 13, true);
          public          postgres    false    202            6           2606    40348    cereri cereri_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.cereri
    ADD CONSTRAINT cereri_pkey PRIMARY KEY (id_column);
 <   ALTER TABLE ONLY public.cereri DROP CONSTRAINT cereri_pkey;
       public            postgres    false    203            2           2606    40338    documente documente_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY public.documente
    ADD CONSTRAINT documente_pkey PRIMARY KEY (id_doc_column);
 B   ALTER TABLE ONLY public.documente DROP CONSTRAINT documente_pkey;
       public            postgres    false    201            4           2606    40340 "   documente documente_tip_column_key 
   CONSTRAINT     c   ALTER TABLE ONLY public.documente
    ADD CONSTRAINT documente_tip_column_key UNIQUE (tip_column);
 L   ALTER TABLE ONLY public.documente DROP CONSTRAINT documente_tip_column_key;
       public            postgres    false    201            8           2606    40363    locuinte locuinte_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.locuinte
    ADD CONSTRAINT locuinte_pkey PRIMARY KEY (id_locuinta_column);
 @   ALTER TABLE ONLY public.locuinte DROP CONSTRAINT locuinte_pkey;
       public            postgres    false    204            0           2606    40333    users users_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id_column);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    200            :           2606    40354 $   cereri cereri_tip_cerere_column_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.cereri
    ADD CONSTRAINT cereri_tip_cerere_column_fkey FOREIGN KEY (tip_cerere_column) REFERENCES public.documente(tip_column);
 N   ALTER TABLE ONLY public.cereri DROP CONSTRAINT cereri_tip_cerere_column_fkey;
       public          postgres    false    201    203    2868            9           2606    40349 !   cereri cereri_user_id_column_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.cereri
    ADD CONSTRAINT cereri_user_id_column_fkey FOREIGN KEY (user_id_column) REFERENCES public.users(id_column);
 K   ALTER TABLE ONLY public.cereri DROP CONSTRAINT cereri_user_id_column_fkey;
       public          postgres    false    203    200    2864            ;           2606    40364 *   locuinte locuinte_id_propietar_column_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.locuinte
    ADD CONSTRAINT locuinte_id_propietar_column_fkey FOREIGN KEY (id_propietar_column) REFERENCES public.users(id_column);
 T   ALTER TABLE ONLY public.locuinte DROP CONSTRAINT locuinte_id_propietar_column_fkey;
       public          postgres    false    204    200    2864            ?   ?   x???=N1??z|
_?????"e??4??,XJ???6?????B\???B??׌*????KV?4i??%??)?-???}????<Q??%?lͬQ?g??l?
?V:W8՞?d??|?ѩ?֥?? n?Jmob??z????~?IQ?I!?c???????K4???نG??|???呁_???0??(g??s??I?	&]n      ?   [   x????0 ??bD⼻????
B????ĵ;:yƔ???4`??s?=???????T???#aR?(Ɔ?E?!???X?5/?s??S?      ?   ?   x???Aj?0?ur?\@E?e[ZN??s?n,ن@??4s?f
]vQ???????L?l??}М??汑?J?j)?)E??	8?B??@Դ?ܵ?0????c??~?.[??:]??{]??/?????l?^fGm???,ad?N???Ε4"?&?D?#h?K??S?)?8vz?'j"??+?J?ؾ?????u;????????1?Q?? 5??#{?????oO?<?d{x      ?   ?   x?m?M
?0?ur??v?;K??p3M?R?"I???Eq?x??㼭W??lU???q?jjۺ????5Y5??????됀S @???qTE???z???&?,?????fq? ????9A?q ;?3E?&???Խ/?o?t?Z? 1?C     